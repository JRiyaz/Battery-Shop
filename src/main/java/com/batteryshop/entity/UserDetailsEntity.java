package com.batteryshop.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = {"user", "referrals", "orders", "faultyProducts", "forgotPassword", "userImage", "proofImage"})
@Table(name = "user_details")
public class UserDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Embedded
    private String names;

    //    @Embedded
    private String phoneNumbers;

    private String gender;

    @Column(name = "proof_type")
    private String proofType;

    @Column(name = "proof_id")
    private String proofId;

    private String profession;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "user_image")
    private ImageEntity userImage;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "proof_image")
    private ImageEntity proofImage;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = AddressEntity.class)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = ReferralEntity.class, mappedBy = "userDetails")
    private List<ReferralEntity> referrals;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = OrderEntity.class, mappedBy = "userDetails")
    private List<OrderEntity> orders;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = FaultyProductEntity.class, mappedBy = "userDetails")
    private List<FaultyProductEntity> faultyProducts;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ForgotPasswordEntity.class, mappedBy = "userDetails")
    private List<ForgotPasswordEntity> forgotPassword;

//    public UserDetailsEntity(Name names, PhoneNumber phoneNumbers, String gender, String proofType, String proofId, String profession, String observation, ImageEntity userImage, ImageEntity proofImage, AddressEntity address, UserEntity user, List<ReferralEntity> referrals, List<OrderEntity> orders, List<FaultyProductEntity> faultyProducts, List<ForgotPasswordEntity> forgotPassword) {
//        this.names = names;
//        this.phoneNumbers = phoneNumbers;
//        this.gender = gender;
//        this.proofType = proofType;
//        this.proofId = proofId;
//        this.profession = profession;
//        this.observation = observation;
//        this.userImage = userImage;
//        this.proofImage = proofImage;
//        this.address = address;
//        this.user = user;
//        this.referrals = referrals;
//        this.orders = orders;
//        this.faultyProducts = faultyProducts;
//        this.forgotPassword = forgotPassword;
//    }
//
//    public UserDetailsEntity(Name names, PhoneNumber phoneNumbers, String gender, String proofType, String proofId, String profession, String observation, ImageEntity userImage, ImageEntity proofImage, AddressEntity address) {
//        this.names = names;
//        this.phoneNumbers = phoneNumbers;
//        this.gender = gender;
//        this.proofType = proofType;
//        this.proofId = proofId;
//        this.profession = profession;
//        this.observation = observation;
//        this.userImage = userImage;
//        this.proofImage = proofImage;
//        this.address = address;
//    }

    public UserDetailsEntity setId(Integer id) {
        this.id = id;
        return this;
    }

//    public UserDetailsEntity setNames(Name names) {
//        this.names = names;
//        return this;
//    }
//
//    public UserDetailsEntity setPhoneNumbers(PhoneNumber phoneNumbers) {
//        this.phoneNumbers = phoneNumbers;
//        return this;
//    }

    public UserDetailsEntity setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserDetailsEntity setProofType(String proofType) {
        this.proofType = proofType;
        return this;
    }

    public UserDetailsEntity setProofId(String proofId) {
        this.proofId = proofId;
        return this;
    }

    public UserDetailsEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public UserDetailsEntity setUserImage(ImageEntity userImage) {
        this.userImage = userImage;
        return this;
    }

    public UserDetailsEntity setProofImage(ImageEntity proofImage) {
        this.proofImage = proofImage;
        return this;
    }

    public UserDetailsEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public UserDetailsEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public UserDetailsEntity setReferrals(List<ReferralEntity> referrals) {
        this.referrals = referrals;
        return this;
    }

    public UserDetailsEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public UserDetailsEntity setFaultyProducts(List<FaultyProductEntity> faultyProducts) {
        this.faultyProducts = faultyProducts;
        return this;
    }

    public UserDetailsEntity setForgotPassword(List<ForgotPasswordEntity> forgotPassword) {
        this.forgotPassword = forgotPassword;
        return this;
    }
}
