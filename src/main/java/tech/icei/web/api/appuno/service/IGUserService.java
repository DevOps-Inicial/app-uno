package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.GUser;

import java.util.List;
import java.util.Optional;

public interface IGUserService {

    List<GUser> findAll();
    List<GUser> findAllEnabled(boolean enabled);
    Optional<GUser> findByUserID(String id);
    GUser save(GUser newGUser);
    GUser update(String id, GUser updGUser);
    GUser delete(String id);
}
