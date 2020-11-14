package com.batteryshop.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = {"faultyProduct", "image"})
@Table(name = "replacement_products")
public class ReplacementProductEntity implements Serializable {

    @Id
    @Column(name = "product_code")
    private String productCode;

    //    @Temporal(TemporalType.DATE)
    @Column(name = "manufactured_on")
    private LocalDate manufacturedOn;

    private Short guarantee;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = FaultyProductEntity.class)
    @JoinColumn(name = "faulty_product_id")
    private FaultyProductEntity faultyProduct;

    public ReplacementProductEntity(String productCode, LocalDate manufacturedOn, Short guarantee, String observation, ImageEntity image) {
        this.productCode = productCode;
        this.manufacturedOn = manufacturedOn;
        this.guarantee = guarantee;
        this.observation = observation;
        this.image = image;
    }

    public ReplacementProductEntity setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public ReplacementProductEntity setManufacturedOn(LocalDate manufacturedOn) {
        this.manufacturedOn = manufacturedOn;
        return this;
    }

    public ReplacementProductEntity setGuarantee(Short guarantee) {
        this.guarantee = guarantee;
        return this;
    }

    public ReplacementProductEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public ReplacementProductEntity setImage(ImageEntity image) {
        this.image = image;
        return this;
    }

    public ReplacementProductEntity setFaultyProduct(FaultyProductEntity faultyProduct) {
        this.faultyProduct = faultyProduct;
        return this;
    }
}
