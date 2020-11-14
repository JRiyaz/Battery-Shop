package com.batteryshop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Name {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Name setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Name setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
