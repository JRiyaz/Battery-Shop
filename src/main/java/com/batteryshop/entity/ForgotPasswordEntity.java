package com.batteryshop.entity;

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
@ToString(exclude = "userDetails")
@Table(name = "forgot_password")
public class ForgotPasswordEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "previous_password")
    private String previousPassword;

    @Column(name = "new_password")
    private String newPassword;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserDetailsEntity.class)
    @JoinColumn(name = "user_details_id")
    private UserDetailsEntity userDetails;

    public ForgotPasswordEntity(String previousPassword, String newPassword, UserDetailsEntity userDetails) {
        this.previousPassword = previousPassword;
        this.newPassword = newPassword;
        this.userDetails = userDetails;
    }

    public ForgotPasswordEntity(String previousPassword, String newPassword) {
        this.previousPassword = previousPassword;
        this.newPassword = newPassword;
    }

    public ForgotPasswordEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public ForgotPasswordEntity setPreviousPassword(String previousPassword) {
        this.previousPassword = previousPassword;
        return this;
    }

    public ForgotPasswordEntity setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public ForgotPasswordEntity setUserDetails(UserDetailsEntity userDetails) {
        this.userDetails = userDetails;
        return this;
    }
}
