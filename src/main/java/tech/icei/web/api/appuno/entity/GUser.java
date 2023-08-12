package tech.icei.web.api.appuno.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "g_users", schema = "icei")
public class GUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="user_id", nullable = false)
    private UUID userId;

    @ColumnTransformer(read = "pgp_sym_decrypt(user_name::bytea,current_setting('encrypt.key'))", write = "pgp_sym_encrypt(?,current_setting('encrypt.key'))")
    @Column(name = "user_name")
    private String username;

    @ColumnTransformer(read = "pgp_sym_decrypt(password::bytea,current_setting('encrypt.key'))", write = "pgp_sym_encrypt(?,current_setting('encrypt.key'))")
    private String password;

    @ColumnTransformer(read = "pgp_sym_decrypt(email::bytea,current_setting('encrypt.key'))", write = "pgp_sym_encrypt(?,current_setting('encrypt.key'))")
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "g_user_roles", schema = "icei",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<GRole> roles = new HashSet<>();

    private boolean enabled;

    @CreatedBy
    @Column(name = "created_by_user", nullable = false, updatable = false)
    private String createdByUser;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by_user")
    private String lastModifiedByUser;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Version
    @Column(name = "number_of_modifications")
    private long numberOfModification;

    public GUser(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
