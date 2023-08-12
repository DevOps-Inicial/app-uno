package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.GUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGUserService {

    List<GUser> findAll();
    List<GUser> findAllEnabled(boolean enabled);
    Optional<GUser> findByUserID(UUID id);
    GUser save(GUser newGUser);
    GUser update(UUID id, GUser updGUser);
    GUser delete(UUID id);
}
