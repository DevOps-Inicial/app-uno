package tech.icei.web.api.appuno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.icei.web.api.appuno.entity.Employee;
import tech.icei.web.api.appuno.repository.EmployeeRespository;
import tech.icei.web.api.appuno.service.IEmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<Employee> findAllEnabled(boolean enabled) {
        return employeeRespository.findAllByEnabled(enabled);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findByEmployeeID(UUID id) {
        return employeeRespository.findByEmployeeId(id);
    }

    @Override
    @Transactional
    public Employee save(Employee newEmployee) {
        return employeeRespository.save(newEmployee);
    }

    @Override
    @Transactional
    public Employee update(UUID id, Employee updEmployee) {
        var updatedEmployee = employeeRespository.findByEmployeeId(id);

        if (updatedEmployee.isPresent()) {
            updatedEmployee.get().setNombreCompleto(updEmployee.getNombreCompleto());
            updatedEmployee.get().setDireccion(updEmployee.getDireccion());
            updatedEmployee.get().setEmail(updEmployee.getEmail());
            updatedEmployee.get().setDireccion(updEmployee.getDireccion());
            updatedEmployee.get().setEnabled(updEmployee.isEnabled());
        }
        return employeeRespository.save(updatedEmployee.get());
    }

    @Override
    @Transactional
    public Employee delete(UUID id) {
        var deletedEmployee = employeeRespository.findByEmployeeId(id);
        deletedEmployee.ifPresent(delEmployee->deletedEmployee.get().setEnabled(false));
        return employeeRespository.save(deletedEmployee.get());
    }
}
