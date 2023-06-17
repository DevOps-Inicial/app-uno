package tech.icei.web.api.appuno.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.icei.web.api.appuno.dto.EmployeeDto;
import tech.icei.web.api.appuno.entity.Employee;
import tech.icei.web.api.appuno.service.IEmployeeService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/fullstack")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final ModelMapper modelMapper = new ModelMapper();

    // Listar a todos los empleados
    @GetMapping("/all-employees")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
        try {
            var employees = employeeService.findAll().stream()
                    .map(allEmp->modelMapper.map(allEmp, EmployeeDto.class)).collect(Collectors.toList());
            log.debug("Listado completo de registros");
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            log.error("Error al obtener el listado " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar todos los registros habilitados enabled = true
    @GetMapping("/enabled-employees/{enabled}")
    public ResponseEntity<List<EmployeeDto>> findAllEnabledEmployees(@PathVariable boolean enabled) {

        try {
            var enabledEmployees = employeeService.findAllEnabled(true).stream()
                    .map(enabEmployees->modelMapper.map(enabEmployees, EmployeeDto.class)).collect(Collectors.toList());
            log.debug("Listado de registros habilitados");
            return new ResponseEntity<>(enabledEmployees, HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            log.error("Error al obtener el listado de habilitados " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Obtener un registro
    @GetMapping("/single-employees/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeByID(@Valid @PathVariable UUID id) {

        try {
            var singleEmployee = employeeService.findByEmployeeID(id);
            var singleEmployeeResponse = modelMapper.map(singleEmployee.get(), EmployeeDto.class);
            log.debug("Un registro");
            return new ResponseEntity<>(singleEmployeeResponse, HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            log.error("Error al obtener un registro " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Guardar un empleado
    @PostMapping("/keep-employees")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto nEmployeeDto) {
        try {
            var employeeRequest = modelMapper.map(nEmployeeDto, Employee.class);
            var savedEmployee = employeeService.save(employeeRequest);
            var employeeResponse = modelMapper.map(savedEmployee, EmployeeDto.class);
            log.debug("Registro guardado exitosamente");
            return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
        }
        catch (DataAccessException daex) {
            log.error("Error al guardar el registro " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar el registro
    @PutMapping("/catchup-employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @PathVariable UUID id, @Valid @RequestBody EmployeeDto uEmployeeDto) {

        try {
            var employeeRequest = modelMapper.map(uEmployeeDto, Employee.class);
            var updatedEmployee = employeeService.update(id, employeeRequest);
            var employeeResponse = modelMapper.map(updatedEmployee, EmployeeDto.class);
            log.debug("Registro actualizado exitosamente");
            return new ResponseEntity<>(employeeResponse, HttpStatus.ACCEPTED);
        }
        catch (DataAccessException daex) {
            log.error("Error al actualizar el registro " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminacio logica del registro
    @PatchMapping("/remove-employees/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployeeByID(@Valid @PathVariable UUID id) {

        try {
            var deletedEmployee = employeeService.delete(id);
            var employeeResponse = modelMapper.map(deletedEmployee, EmployeeDto.class);
            log.debug("Registro eliminado");
            return new ResponseEntity<>(employeeResponse, HttpStatus.NO_CONTENT);
        }
        catch (DataAccessException daex) {
            log.error("Error al eliminar el registro " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
