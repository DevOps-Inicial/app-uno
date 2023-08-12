package tech.icei.web.api.appuno.dto;

import lombok.Data;
import tech.icei.web.api.appuno.entity.ERole;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GRoleDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5520696402793181123L;
    private UUID roleId;
    private ERole name;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long numberOfModification;
}
