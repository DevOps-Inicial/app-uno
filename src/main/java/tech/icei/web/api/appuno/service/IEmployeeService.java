package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> findAll();
    List<Employee> findAllEnabled(boolean enabled);
    Optional<Employee> findByEmployeeID(String id);
    Employee save(Employee newEmployee);
    Employee update(String id, Employee updEmployee);
    Employee delete(String id);
}
