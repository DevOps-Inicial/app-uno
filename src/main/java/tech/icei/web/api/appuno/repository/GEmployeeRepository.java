package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.GEmployee;

import java.util.List;
import java.util.Optional;

public interface GEmployeeRepository extends JpaRepository<GEmployee, String> {

    Optional<GEmployee> findByEmployeeId(String id);
    List<GEmployee> findAllByEnabled(boolean enabled);
}
