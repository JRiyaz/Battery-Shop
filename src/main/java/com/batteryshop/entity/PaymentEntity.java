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
@ToString(exclude = {"stock", "order", "paymentDetails", "faultyProduct"})
@Table(name = "payments")
public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "due_amount")
    private Double dueAmount;

    @Column(name = "due_date")
//    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = StockEntity.class)
    @JoinColumn(name = "stock_id")
    private StockEntity stock;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = StockEntity.class)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = FaultyProductEntity.class)
    @JoinColumn(name = "faulty_product_id")
    private FaultyProductEntity faultyProduct;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = PaymentDetailsEntity.class, mappedBy = "payments")
    private List<PaymentDetailsEntity> paymentDetails;

    public PaymentEntity(Double totalAmount, Double amountPaid, Double dueAmount, LocalDate dueDate, StockEntity stock, OrderEntity order, FaultyProductEntity faultyProduct, List<PaymentDetailsEntity> paymentDetails) {
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
        this.stock = stock;
        this.order = order;
        this.faultyProduct = faultyProduct;
        this.paymentDetails = paymentDetails;
    }

    public PaymentEntity(Double totalAmount, Double amountPaid, Double dueAmount, LocalDate dueDate) {
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
    }

    public PaymentEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaymentEntity setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public PaymentEntity setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
        return this;
    }

    public PaymentEntity setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
        return this;
    }

    public PaymentEntity setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PaymentEntity setStock(StockEntity stock) {
        this.stock = stock;
        return this;
    }

    public PaymentEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }

    public PaymentEntity setFaultyProduct(FaultyProductEntity faultyProduct) {
        this.faultyProduct = faultyProduct;
        return this;
    }

    public PaymentEntity setPaymentDetails(List<PaymentDetailsEntity> paymentDetails) {
        this.paymentDetails = paymentDetails;
        return this;
    }
}
