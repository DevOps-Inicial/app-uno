package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.GRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGRoleService {

    List<GRole> findAll();
    List<GRole> findAllEnabled(boolean enabled);
    Optional<GRole> findByRoleID(UUID id);
    GRole save(GRole newGRole);
    GRole update(UUID id, GRole updGRole);
    GRole delete(UUID id);
}
