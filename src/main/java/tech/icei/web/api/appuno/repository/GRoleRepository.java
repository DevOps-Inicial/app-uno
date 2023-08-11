package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.ERole;
import tech.icei.web.api.appuno.entity.GRole;

import java.util.List;
import java.util.Optional;

public interface GRoleRepository extends JpaRepository<GRole, String> {
    Optional<GRole> findByName(ERole roleName);
    Optional<GRole> findByRoleId(String id);
    List<GRole> findAllByEnabledOrderByRoleIdAsc(boolean enabled);
}
