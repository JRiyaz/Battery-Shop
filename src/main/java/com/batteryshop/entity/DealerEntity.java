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
@ToString(exclude = {"stocks", "dealerImage"})
@Table(name = "dealers")
public class DealerEntity implements Serializable {

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
    private ImageEntity dealerImage;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = AddressEntity.class)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = StockEntity.class, mappedBy = "dealer")
    private List<StockEntity> stocks;

//    public DealerEntity(Name names, PhoneNumber phoneNumbers, String email, String observation, ImageEntity dealerImage, AddressEntity address, List<StockEntity> stocks) {
//        this.names = names;
//        this.phoneNumbers = phoneNumbers;
//        this.email = email;
//        this.observation = observation;
//        this.dealerImage = dealerImage;
//        this.address = address;
//        this.stocks = stocks;
//    }
//
//    public DealerEntity(Name names, PhoneNumber phoneNumbers, String email, String observation) {
//        this.names = names;
//        this.phoneNumbers = phoneNumbers;
//        this.email = email;
//        this.observation = observation;
//    }

    public DealerEntity setId(Integer id) {
        this.id = id;
        return this;
    }

//    public DealerEntity setNames(Name names) {
//        this.names = names;
//        return this;
//    }
//
//    public DealerEntity setPhoneNumbers(PhoneNumber phoneNumbers) {
//        this.phoneNumbers = phoneNumbers;
//        return this;
//    }

    public DealerEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public DealerEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public DealerEntity setDealerImage(ImageEntity dealerImage) {
        this.dealerImage = dealerImage;
        return this;
    }

    public DealerEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public DealerEntity setStocks(List<StockEntity> stocks) {
        this.stocks = stocks;
        return this;
    }
}
