package tech.icei.web.api.appuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.icei.web.api.appuno.entity.GUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GUserRepository extends JpaRepository<GUser, UUID> {

    Optional<GUser> findByUsername(String username);
    Optional<GUser> findByUserId(UUID id);
    List<GUser> findAllByEnabledOrderByUserIdAsc(boolean enabled);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
