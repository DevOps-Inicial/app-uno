package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.Employee;

import java.util.Optional;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    // Definir un metodo para la busqueda por EmployeeId
    Optional<Employee> findByEmployeeId(Long id);
}
