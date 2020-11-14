package com.batteryshop.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@DynamicUpdate
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "address")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String landmark;

    private String city;

    private String pincode;

    public AddressEntity(String street, String landmark, String city, String pincode) {
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.pincode = pincode;
    }

    public AddressEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public AddressEntity setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressEntity setLandmark(String landmark) {
        this.landmark = landmark;
        return this;
    }

    public AddressEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressEntity setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }
}
