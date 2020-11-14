package com.batteryshop.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = {"productFeatures", "products", "productImage"})
@Table(name = "product_details")
public class ProductDetailsEntity implements Serializable {

    @Id
    @Column(length = 100, nullable = false, unique = true)
    private String id;

    private String category;

    @Column(name = "vehicle_type")
    private String vehicleType;

    private String manufacturer;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_model")
    private String productModel;

    private Short guarantee;

    private Short warranty;

    private Double weight;

    private Integer capacity;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "image_id")
    private ImageEntity productImage;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductEntity.class, mappedBy = "productDetails")
    private List<ProductEntity> products;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = ProductFeaturesEntity.class, mappedBy = "productDetails")
    private List<ProductFeaturesEntity> productFeatures;

    public ProductDetailsEntity(String category, String vehicleType, String manufacturer, String vehicleModel, String productType, String brandName, String productName, String productModel, Short guarantee, Short warranty, Double weight, Integer capacity, ImageEntity productImage, List<ProductEntity> products, List<ProductFeaturesEntity> productFeatures) {
        this.category = category;
        this.vehicleType = vehicleType;
        this.manufacturer = manufacturer;
        this.vehicleModel = vehicleModel;
        this.productType = productType;
        this.brandName = brandName;
        this.productName = productName;
        this.productModel = productModel;
        this.guarantee = guarantee;
        this.warranty = warranty;
        this.weight = weight;
        this.capacity = capacity;
        this.productImage = productImage;
        this.products = products;
        this.productFeatures = productFeatures;
        this.id = this.generateId();
    }

    public ProductDetailsEntity(String category, String vehicleType, String manufacturer, String vehicleModel, String productType, String brandName, String productName, String productModel, Short guarantee, Short warranty, Double weight, Integer capacity) {
        this.category = category;
        this.vehicleType = vehicleType;
        this.manufacturer = manufacturer;
        this.vehicleModel = vehicleModel;
        this.productType = productType;
        this.brandName = brandName;
        this.productName = productName;
        this.productModel = productModel;
        this.guarantee = guarantee;
        this.warranty = warranty;
        this.weight = weight;
        this.capacity = capacity;
        this.id = this.generateId();
    }

    public ProductDetailsEntity setId(String id) {
        this.id = id;
        return this;
    }

    public ProductDetailsEntity setCategory(String category) {
        this.category = category;
        return this;
    }

    public ProductDetailsEntity setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public ProductDetailsEntity setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public ProductDetailsEntity setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
        return this;
    }

    public ProductDetailsEntity setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public ProductDetailsEntity setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public ProductDetailsEntity setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductDetailsEntity setProductModel(String productModel) {
        this.productModel = productModel;
        return this;
    }

    public ProductDetailsEntity setGuarantee(Short guarantee) {
        this.guarantee = guarantee;
        return this;
    }

    public ProductDetailsEntity setWarranty(Short warranty) {
        this.warranty = warranty;
        return this;
    }

    public ProductDetailsEntity setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public ProductDetailsEntity setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public ProductDetailsEntity setProductImage(ImageEntity productImage) {
        this.productImage = productImage;
        return this;
    }

    public ProductDetailsEntity setProducts(List<ProductEntity> products) {
        this.products = products;
        return this;
    }

    public ProductDetailsEntity setProductFeatures(List<ProductFeaturesEntity> productFeatures) {
        this.productFeatures = productFeatures;
        return this;
    }

    private String generateId() {

        StringBuilder stringBuilder = new StringBuilder();

        char[] id = {this.category.charAt(0), this.vehicleType.charAt(0), this.manufacturer.charAt(0),
                this.productType.charAt(0), this.brandName.charAt(0), this.productName.charAt(0)};

        stringBuilder.append(String.valueOf(id));
        stringBuilder.append(this.vehicleType);
        stringBuilder.append(this.productModel);
        return stringBuilder.toString();
    }
}
