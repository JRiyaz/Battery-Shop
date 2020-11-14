package com.batteryshop.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = {"stock", "productDetails", "order", "faultyProducts", "complaints"})
@Table(name = "products")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "manufactured_on")
//    @Temporal(TemporalType.DATE)
    private LocalDate manufacturedOn;

    private Double mrp;

    @Column(name = "selling_price")
    private Double sellingPrice;

    private Boolean sold;

    @Column(length = 1000)
    private String observation;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = ProductDetailsEntity.class)
    @JoinColumn(name = "product_details_id")
    private ProductDetailsEntity productDetails;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = StockEntity.class)
    @JoinColumn(name = "stock_id")
    private StockEntity stock;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = OrderEntity.class)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = FaultyProductEntity.class, mappedBy = "products")
    private List<FaultyProductEntity> faultyProducts;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ComplaintsEntity.class, mappedBy = "products")
    private List<ComplaintsEntity> complaints;

    public ProductEntity(String productCode, LocalDate manufacturedOn, Double mrp, Double sellingPrice, Boolean sold, String observation) {
        this.productCode = productCode;
        this.manufacturedOn = manufacturedOn;
        this.mrp = mrp;
        this.sellingPrice = sellingPrice;
        this.sold = sold;
        this.observation = observation;
    }

    public ProductEntity setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public ProductEntity setManufacturedOn(LocalDate manufacturedOn) {
        this.manufacturedOn = manufacturedOn;
        return this;
    }

    public ProductEntity setMrp(Double mrp) {
        this.mrp = mrp;
        return this;
    }

    public ProductEntity setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }

    public ProductEntity setSold(Boolean sold) {
        this.sold = sold;
        return this;
    }

    public ProductEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public ProductEntity setProductDetails(ProductDetailsEntity productDetails) {
        this.productDetails = productDetails;
        return this;
    }

    public ProductEntity setStock(StockEntity stock) {
        this.stock = stock;
        return this;
    }

    public ProductEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }

    public ProductEntity setFaultyProducts(List<FaultyProductEntity> faultyProducts) {
        this.faultyProducts = faultyProducts;
        return this;
    }

    public ProductEntity setComplaints(List<ComplaintsEntity> complaints) {
        this.complaints = complaints;
        return this;
    }
}
