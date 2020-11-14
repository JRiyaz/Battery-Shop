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
@ToString(exclude = "productDetails")
@Table(name = "product_features")
public class ProductFeaturesEntity implements Serializable {

    @Id
    @Column(length = 300)
    private String id;

    private String feature;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = ProductDetailsEntity.class)
    @JoinTable(name = "product_details_features",
            joinColumns = @JoinColumn(name = "product_features_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_details_id", referencedColumnName = "id"))
    private List<ProductDetailsEntity> productDetails;

    public ProductFeaturesEntity(String feature, List<ProductDetailsEntity> productDetails) {
        this.feature = feature;
        this.productDetails = productDetails;
        this.id = feature.toLowerCase().replaceAll(" ", "");
    }

    public ProductFeaturesEntity(String feature) {
        this.feature = feature;
        this.id = feature.toLowerCase().replaceAll(" ", "");
    }

    public ProductFeaturesEntity setId(String id) {
        this.id = id;
        return this;
    }

    public ProductFeaturesEntity setFeature(String feature) {
        this.feature = feature;
        return this;
    }

    public ProductFeaturesEntity setProductDetails(List<ProductDetailsEntity> productDetails) {
        this.productDetails = productDetails;
        return this;
    }
}
