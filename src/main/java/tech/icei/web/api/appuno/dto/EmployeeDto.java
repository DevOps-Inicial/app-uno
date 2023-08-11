package tech.icei.web.api.appuno.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmployeeDto implements Serializable {

    private String employeeId;
    private String nombreCompleto;
    private String direccion;
    private String puestoAsignado;
    private boolean enabled;
    private String creadoPor;
    private LocalDateTime fechaCreacion;
    private String modificadoPor;
    private LocalDateTime fechaModificacion;
    private long numeroModificacion;
}
