package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.ERole;
import tech.icei.web.api.appuno.entity.GRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GRoleRepository extends JpaRepository<GRole, UUID> {
    Optional<GRole> findByName(ERole roleName);
    Optional<GRole> findByRoleId(UUID id);
    List<GRole> findAllByEnabledOrderByRoleIdAsc(boolean enabled);
}
