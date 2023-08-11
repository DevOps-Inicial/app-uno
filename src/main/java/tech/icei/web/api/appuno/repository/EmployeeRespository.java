package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRespository extends JpaRepository<Employee, String> {

    // Definir un metodo para la busqueda por EmployeeId
    Optional<Employee> findByEmployeeId(String id);
    List<Employee> findAllByEnabled(boolean enabled);
}
