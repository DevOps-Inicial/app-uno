package tech.icei.web.api.appuno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.icei.web.api.appuno.entity.GRole;
import tech.icei.web.api.appuno.repository.GRoleRepository;
import tech.icei.web.api.appuno.service.IGRoleService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GRoleServiceImpl implements IGRoleService {

    private final GRoleRepository roleRepository;
    @Override
    @Transactional(readOnly = true)
    public List<GRole> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<GRole> findAllEnabled(boolean enabled) {
        return roleRepository.findAllByEnabledOrderByRoleIdAsc(enabled);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GRole> findByRoleID(String id) {
        return roleRepository.findByRoleId(id);
    }

    @Override
    @Transactional
    public GRole save(GRole newGRole) {
        return roleRepository.save(newGRole);
    }

    @Override
    @Transactional
    public GRole update(String id, GRole updGRole) {

        var updatedGRole = roleRepository.findByRoleId(id);
        if (updatedGRole.isPresent()) {
            updatedGRole.get().setName(updGRole.getName());
            updatedGRole.get().setEnabled(updGRole.isEnabled());
        }
        return roleRepository.save(updatedGRole.get());
    }

    @Override
    @Transactional
    public GRole delete(String id) {
        var deletedGRole = roleRepository.findByRoleId(id);
        deletedGRole.ifPresent(delGRole -> deletedGRole.get().setEnabled(false));
        return roleRepository.save(deletedGRole.get());
    }
}
