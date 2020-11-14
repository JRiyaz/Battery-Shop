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
@ToString(exclude = {"userDetails", "image"})
@Table(name = "referrals")
public class ReferralEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Embedded
    private String names;

    //    @Embedded
    private String phoneNumbers;

    private String email;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = AddressEntity.class)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = UserDetailsEntity.class)
    @JoinTable(name = "user_referrals",
            joinColumns = @JoinColumn(name = "referral_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userdetails_id", referencedColumnName = "id"))
    private List<UserDetailsEntity> userDetails;
//
//    public ReferralEntity(Name names, PhoneNumber phoneNumbers, String email, String observation, ImageEntity image, AddressEntity address, List<UserDetailsEntity> userDetails) {
//        this.names = names;
//        this.phoneNumbers = phoneNumbers;
//        this.email = email;
//        this.observation = observation;
//        this.image = image;
//        this.address = address;
//        this.userDetails = userDetails;
//    }
//
//    public ReferralEntity(Name names, PhoneNumber phoneNumbers, String email, String observation, ImageEntity image, AddressEntity address) {
//        this.names = names;
//        this.phoneNumbers = phoneNumbers;
//        this.email = email;
//        this.observation = observation;
//        this.image = image;
//        this.address = address;
//    }

    public ReferralEntity setId(Integer id) {
        this.id = id;
        return this;
    }

//    public ReferralEntity setNames(Name names) {
//        this.names = names;
//        return this;
//    }
//
//    public ReferralEntity setPhoneNumbers(PhoneNumber phoneNumbers) {
//        this.phoneNumbers = phoneNumbers;
//        return this;
//    }

    public ReferralEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public ReferralEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public ReferralEntity setImage(ImageEntity image) {
        this.image = image;
        return this;
    }

    public ReferralEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public ReferralEntity setUserDetails(List<UserDetailsEntity> userDetails) {
        this.userDetails = userDetails;
        return this;
    }
}
