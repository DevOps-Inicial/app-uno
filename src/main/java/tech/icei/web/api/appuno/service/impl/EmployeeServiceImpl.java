package tech.icei.web.api.appuno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.icei.web.api.appuno.entity.Employee;
import tech.icei.web.api.appuno.repository.EmployeeRespository;
import tech.icei.web.api.appuno.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRespository employeeRespository;
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findByEmployeeID(Long id) {
        return employeeRespository.findByEmployeeId(id);
    }

    @Override
    @Transactional
    public Employee save(Employee newEmployee) {
        return employeeRespository.save(newEmployee);
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee updEmployee) {

        // Obtener el ID del registro a actualizar
        var updatedEmployee = employeeRespository.findByEmployeeId(id);

        if (updatedEmployee.isPresent()) {
            updatedEmployee.get().setNombreCompleto(updEmployee.getNombreCompleto());
            updatedEmployee.get().setDireccion(updEmployee.getDireccion());
            updatedEmployee.get().setPuestoAsignado(updEmployee.getPuestoAsignado());
        }
        return employeeRespository.save(updatedEmployee.get());
    }
}
