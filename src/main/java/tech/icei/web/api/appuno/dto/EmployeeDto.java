package tech.icei.web.api.appuno.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class EmployeeDto implements Serializable {

    private Long employeeId;
    private String nombreCompleto;
    private String direccion;
    private String puestoAsignado;
}
