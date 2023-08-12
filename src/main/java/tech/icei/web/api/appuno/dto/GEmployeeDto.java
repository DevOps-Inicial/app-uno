package tech.icei.web.api.appuno.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GEmployeeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5520696402793181123L;

    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellPhone;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long numberOfModification;
}
