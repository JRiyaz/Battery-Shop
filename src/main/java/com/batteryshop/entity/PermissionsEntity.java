package com.batteryshop.entity;

import com.batteryshop.model.UserPermission;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = "users")
@Table(name = "permissions")
public class PermissionsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //  https://www.baeldung.com/jpa-persisting-enums-in-jpa
    @Enumerated(EnumType.STRING)
    private UserPermission permission;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    @JoinTable(name = "user_permissions",
            joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private UserEntity users;

    public PermissionsEntity(UserPermission permission, UserEntity users) {
        this.permission = permission;
        this.users = users;
    }

    public PermissionsEntity(UserPermission permission) {
        this.permission = permission;
    }

    public PermissionsEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public PermissionsEntity setPermission(UserPermission permission) {
        this.permission = permission;
        return this;
    }

    public PermissionsEntity setUsers(UserEntity users) {
        this.users = users;
        return this;
    }
}
