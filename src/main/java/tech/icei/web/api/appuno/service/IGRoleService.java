package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.GRole;

import java.util.List;
import java.util.Optional;

public interface IGRoleService {

    List<GRole> findAll();
    List<GRole> findAllEnabled(boolean enabled);
    Optional<GRole> findByRoleID(String id);
    GRole save(GRole newGRole);
    GRole update(String id, GRole updGRole);
    GRole delete(String id);
}
