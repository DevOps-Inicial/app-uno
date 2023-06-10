package tech.icei.web.api.appuno.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.icei.web.api.appuno.dto.EmployeeDto;
import tech.icei.web.api.appuno.entity.Employee;
import tech.icei.web.api.appuno.service.IEmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/fullstack")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final ModelMapper modelMapper = new ModelMapper();

    // Listar a todos los empleados
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
        try {
            var employees = employeeService.findAll().stream()
                    .map(allEmp->modelMapper.map(allEmp, EmployeeDto.class)).collect(Collectors.toList());
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener un registro
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeByID(@PathVariable Long id) {

        try {
            var singleEmployee = employeeService.findByEmployeeID(id);
            var singleEmployeeResponse = modelMapper.map(singleEmployee.get(), EmployeeDto.class);

            return new ResponseEntity<>(singleEmployeeResponse, HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Guardar un empleado
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto nEmployeeDto) {
        try {
            var employeeRequest = modelMapper.map(nEmployeeDto, Employee.class);
            var savedEmployee = employeeService.save(employeeRequest);
            var employeeResponse = modelMapper.map(savedEmployee, EmployeeDto.class);

            return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
        }
        catch (DataAccessException daex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar el registro
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto uEmployeeDto) {

        try {
            var employeeRequest = modelMapper.map(uEmployeeDto, Employee.class);
            var updatedEmployee = employeeService.update(id, employeeRequest);
            var employeeResponse = modelMapper.map(updatedEmployee, EmployeeDto.class);

            return new ResponseEntity<>(employeeResponse, HttpStatus.ACCEPTED);
        }
        catch (DataAccessException daex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
