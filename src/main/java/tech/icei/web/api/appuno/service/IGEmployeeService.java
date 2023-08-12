package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.GEmployee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGEmployeeService {

    List<GEmployee> findAll();
    List<GEmployee> findAllEnabled(boolean enabled);
    Optional<GEmployee> findByEmployeeID(UUID id);
    GEmployee save(GEmployee newGEmployee);
    GEmployee update(UUID id, GEmployee updGEmployee);
    GEmployee delete(UUID id);
}
