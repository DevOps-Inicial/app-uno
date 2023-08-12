package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.GEmployee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GEmployeeRepository extends JpaRepository<GEmployee, UUID> {

    Optional<GEmployee> findByEmployeeId(UUID id);
    List<GEmployee> findAllByEnabled(boolean enabled);
}
