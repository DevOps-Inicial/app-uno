package tech.icei.web.api.appuno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.icei.web.api.appuno.entity.GEmployee;
import tech.icei.web.api.appuno.repository.GEmployeeRepository;
import tech.icei.web.api.appuno.service.IGEmployeeService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GEmployeeServiceImpl implements IGEmployeeService {

    private final GEmployeeRepository employeeRespository;

    @Override
    @Transactional(readOnly = true)
    public List<GEmployee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<GEmployee> findAllEnabled(boolean enabled) {
        return employeeRespository.findAllByEnabled(enabled);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GEmployee> findByEmployeeID(String id) {
        return employeeRespository.findByEmployeeId(id);
    }

    @Override
    @Transactional
    public GEmployee save(GEmployee newGEmployee) {
        return employeeRespository.save(newGEmployee);
    }

    @Override
    @Transactional
    public GEmployee update(String id, GEmployee updGEmployee) {

        var updatedEmployee = employeeRespository.findByEmployeeId(id);
        if (updatedEmployee.isPresent()) {
            updatedEmployee.get().setFirstName(updGEmployee.getFirstName());
            updatedEmployee.get().setLastName(updGEmployee.getLastName());
            updatedEmployee.get().setEmail(updGEmployee.getEmail());
            updatedEmployee.get().setAddress(updGEmployee.getAddress());
            updatedEmployee.get().setCellPhone(updGEmployee.getCellPhone());
            updatedEmployee.get().setEnabled(updGEmployee.isEnabled());
        }
        return employeeRespository.save(updatedEmployee.get());
    }

    @Override
    @Transactional
    public GEmployee delete(String id) {
        var deletedEmployee = employeeRespository.findByEmployeeId(id);
        deletedEmployee.ifPresent(delGEmployee ->deletedEmployee.get().setEnabled(false));
        return employeeRespository.save(deletedEmployee.get());
    }
}
