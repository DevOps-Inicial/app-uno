package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    // Crear los metodos para realizar el CRUD respectivo
    // Listar todos los registros
    List<Employee> findAll();
    Optional<Employee> findByEmployeeID(Long id);
    Employee save(Employee newEmployee);
    Employee update(Long id, Employee updEmployee);
}
