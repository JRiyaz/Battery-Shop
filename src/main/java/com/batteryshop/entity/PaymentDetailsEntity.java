package com.batteryshop.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@ToString(exclude = {"payments", "receipt"})
@Table(name = "payment_details")
public class PaymentDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "image_id")
    private ImageEntity receipt;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = PaymentEntity.class)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payments;

    public PaymentDetailsEntity(Double amountPaid, String paymentMode, String transactionId, String observation, ImageEntity receipt, PaymentEntity payments) {
        this.amountPaid = amountPaid;
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
        this.observation = observation;
        this.receipt = receipt;
        this.payments = payments;
    }

    public PaymentDetailsEntity(Double amountPaid, String paymentMode, String transactionId, String observation, ImageEntity receipt) {
        this.amountPaid = amountPaid;
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
        this.observation = observation;
        this.receipt = receipt;
    }

    public PaymentDetailsEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaymentDetailsEntity setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
        return this;
    }

    public PaymentDetailsEntity setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public PaymentDetailsEntity setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public PaymentDetailsEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public PaymentDetailsEntity setReceipt(ImageEntity receipt) {
        this.receipt = receipt;
        return this;
    }

    public PaymentDetailsEntity setPayments(PaymentEntity payments) {
        this.payments = payments;
        return this;
    }
}
