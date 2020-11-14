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
@ToString(exclude = {"dealer", "products", "payment", "billImage"})
@Table(name = "stock")
public class StockEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double expenses;

    private Double tax;

    @Column(name = "bill_amount")
    private Double billAmount;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "image_id")
    private ImageEntity billImage;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = DealerEntity.class)
    @JoinColumn(name = "dealer_id")
    private DealerEntity dealer;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductEntity.class, mappedBy = "stock")
    private List<ProductEntity> products;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = PaymentEntity.class, mappedBy = "stock")
    private PaymentEntity payment;

    public StockEntity(Double expenses, Double tax, Double billAmount, String observation, ImageEntity billImage, DealerEntity dealer, List<ProductEntity> products, PaymentEntity payment) {
        this.expenses = expenses;
        this.tax = tax;
        this.billAmount = billAmount;
        this.observation = observation;
        this.billImage = billImage;
        this.dealer = dealer;
        this.products = products;
        this.payment = payment;
    }

    public StockEntity(Double expenses, Double tax, Double billAmount, String observation, ImageEntity billImage) {
        this.expenses = expenses;
        this.tax = tax;
        this.billAmount = billAmount;
        this.observation = observation;
        this.billImage = billImage;
    }

    public StockEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public StockEntity setExpenses(Double expenses) {
        this.expenses = expenses;
        return this;
    }

    public StockEntity setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public StockEntity setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
        return this;
    }

    public StockEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public StockEntity setBillImage(ImageEntity billImage) {
        this.billImage = billImage;
        return this;
    }

    public StockEntity setDealer(DealerEntity dealer) {
        this.dealer = dealer;
        return this;
    }

    public StockEntity setProducts(List<ProductEntity> products) {
        this.products = products;
        return this;
    }

    public StockEntity setPayment(PaymentEntity payment) {
        this.payment = payment;
        return this;
    }
}
