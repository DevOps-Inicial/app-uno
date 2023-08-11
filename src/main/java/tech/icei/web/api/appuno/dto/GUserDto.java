package tech.icei.web.api.appuno.dto;

import lombok.Data;
import tech.icei.web.api.appuno.entity.GRole;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
@Data
public class GUserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5520696402793181123L;

    private String userId;
    private String username;
    private String password;
    private String email;
    private Set<GRole> roles;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long numberOfModification;
}
