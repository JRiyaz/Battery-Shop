package com.batteryshop.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhoneNumber {

    private String primary;

    private String secondary;

    public PhoneNumber setPrimary(String primary) {
        this.primary = primary;
        return this;
    }

    public PhoneNumber setSecondary(String secondary) {
        this.secondary = secondary;
        return this;
    }
}
