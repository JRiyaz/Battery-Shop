package com.batteryshop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"userDetails", "products", "payment", "billImage"})
@Table(name = "orders")
public class OrderEntity implements Serializable {

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

    @ManyToOne(targetEntity = UserDetailsEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userdetails_id", nullable = false)
    private UserDetailsEntity userDetails;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductEntity.class, mappedBy = "order")
    private List<ProductEntity> products;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = PaymentEntity.class, mappedBy = "order")
    private PaymentEntity payment;

    public OrderEntity(Double expenses, Double tax, Double billAmount, String observation, ImageEntity billImage, List<ProductEntity> products, PaymentEntity payment, UserDetailsEntity userDetails) {
        this.expenses = expenses;
        this.tax = tax;
        this.billAmount = billAmount;
        this.observation = observation;
        this.billImage = billImage;
        this.products = products;
        this.payment = payment;
        this.userDetails = userDetails;
    }

    public OrderEntity(Double expenses, Double tax, Double billAmount, String observation, ImageEntity billImage) {
        this.expenses = expenses;
        this.tax = tax;
        this.billAmount = billAmount;
        this.observation = observation;
        this.billImage = billImage;
    }

    public OrderEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public OrderEntity setExpenses(Double expenses) {
        this.expenses = expenses;
        return this;
    }

    public OrderEntity setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public OrderEntity setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
        return this;
    }

    public OrderEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public OrderEntity setBillImage(ImageEntity billImage) {
        this.billImage = billImage;
        return this;
    }

    public OrderEntity setProducts(List<ProductEntity> products) {
        this.products = products;
        return this;
    }

    public OrderEntity setPayment(PaymentEntity payment) {
        this.payment = payment;
        return this;
    }

    public OrderEntity setUserDetails(UserDetailsEntity userDetails) {
        this.userDetails = userDetails;
        return this;
    }
}
