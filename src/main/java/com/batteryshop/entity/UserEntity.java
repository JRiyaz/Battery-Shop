package com.batteryshop.entity;

import com.batteryshop.model.UserRole;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
//@PasswordMatches
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = {"password", "userDetails"})
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @ValidEmail
    @Email
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @NotEmpty(message = "password should not be empty")
    @NotBlank(message = "Password should not be blank")
    @Column(nullable = false)
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "account_not_expired")
    private Boolean isAccountNonExpired;

    @Column(name = "account_not_locked")
    private Boolean isAccountNonLocked;

    @Column(name = "credential_not_expired")
    private Boolean isCredentialsNonExpired;

    @Column(name = "is_active")
    private Boolean isEnabled;

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "user_role", length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    //    https://www.baeldung.com/jpa-joincolumn-vs-mappedby

    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "user",
            targetEntity = UserDetailsEntity.class)
    private UserDetailsEntity userDetails;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "users",
            targetEntity = PermissionsEntity.class)
    private List<PermissionsEntity> permissions;

   /* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_permissions",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private List<PermissionsEntity> permissionsEntities;*/

    public UserEntity(String email, @NotEmpty(message = "password should not be empty") @NotBlank(message = "Password should not be blank") String password, String confirmPassword, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnabled, LocalDateTime lastLogin, UserRole userRole, UserDetailsEntity userDetails, List<PermissionsEntity> permissions) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.lastLogin = lastLogin;
        this.userRole = userRole;
        this.userDetails = userDetails;
        this.permissions = permissions;
    }

    public UserEntity(String email, @NotEmpty(message = "password should not be empty") @NotBlank(message = "Password should not be blank") String password, String confirmPassword, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnabled, LocalDateTime lastLogin, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.lastLogin = lastLogin;
        this.userRole = userRole;
    }

    public UserEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public UserEntity setAccountNonExpired(Boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
        return this;
    }

    public UserEntity setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    public UserEntity setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public UserEntity setEnabled(Boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public UserEntity setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public UserEntity setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserEntity setUserDetails(UserDetailsEntity userDetails) {
        this.userDetails = userDetails;
        return this;
    }

    public UserEntity setPermissions(List<PermissionsEntity> permissions) {
        this.permissions = permissions;
        return this;
    }
}
