package tech.icei.web.api.appuno.service;

import tech.icei.web.api.appuno.entity.GEmployee;

import java.util.List;
import java.util.Optional;

public interface IGEmployeeService {

    List<GEmployee> findAll();
    List<GEmployee> findAllEnabled(boolean enabled);
    Optional<GEmployee> findByEmployeeID(String id);
    GEmployee save(GEmployee newGEmployee);
    GEmployee update(String id, GEmployee updGEmployee);
    GEmployee delete(String id);
}
