package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService {

    // Crear los metodos para realizar el CRUD respectivo
    // Listar todos los registros
    List<Employee> findAll();
    // Listar todos los registros habilitados (enabled true)
    List<Employee> findAllEnabled(boolean enabled);
    Optional<Employee> findByEmployeeID(UUID id);
    Employee save(Employee newEmployee);
    Employee update(UUID id, Employee updEmployee);
    Employee delete(UUID id);
}
