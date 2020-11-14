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
@ToString(exclude = {"userDetails", "products", "payment", "billImage", "faultyProductImage"})
@Table(name = "faulty_products")
public class FaultyProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "issue_occurred_on")
//    @Temporal(TemporalType.DATE)
    private LocalDate issueOccurredOn;

    @Column(name = "issue_due_to")
    private String issueDueTo;

    @Column(name = "product_received_on")
//    @Temporal(TemporalType.DATE)
    private LocalDate productReceivedOn;

    @Column(name = "physical_damages")
    private Boolean physicalDamages;

    @Column(name = "under_warranty")
    private Boolean underWarranty;

    @Column(name = "time_given")
    private Integer timeGiven;

    @Column(name = "spare_given")
    private Boolean spareGiven;

    @Column(name = "spare_product_code")
    private String spareProductCode;

    private Double expenses;

    private Double tax;

    @Column(name = "bill_amount")
    private Double billAmount;

    @Column(name = "product_arrived_on")
//    @Temporal(TemporalType.DATE)
    private LocalDate productArrivedOn;

    @Column(name = "product_delivered_on")
//    @Temporal(TemporalType.DATE)
    private LocalDate productDeliveredOn;

    @Column(name = "product_delivered")
    private Boolean productDelivered;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "bill_image")
    private ImageEntity billImage;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "faulty_product_image")
    private ImageEntity faultyProductImage;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserDetailsEntity.class)
    @JoinColumn(name = "user_details_id")
    private UserDetailsEntity userDetails;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = ProductEntity.class)
    @JoinColumn(name = "product_id")
    private ProductEntity products;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = PaymentEntity.class, mappedBy = "faultyProduct")
    private PaymentEntity payment;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ReplacementProductEntity.class, mappedBy = "faultyProduct")
    private ReplacementProductEntity replacementProduct;

    public FaultyProductEntity(LocalDate issueOccurredOn, String issueDueTo, LocalDate productReceivedOn, Boolean physicalDamages, Boolean underWarranty, Integer timeGiven, Boolean spareGiven, String spareProductCode, Double expenses, Double tax, Double billAmount, LocalDate productArrivedOn, LocalDate productDeliveredOn, Boolean productDelivered, String observation, ImageEntity billImage, ImageEntity faultyProductImage, UserDetailsEntity userDetails, ProductEntity products, PaymentEntity payment, ReplacementProductEntity replacementProduct) {
        this.issueOccurredOn = issueOccurredOn;
        this.issueDueTo = issueDueTo;
        this.productReceivedOn = productReceivedOn;
        this.physicalDamages = physicalDamages;
        this.underWarranty = underWarranty;
        this.timeGiven = timeGiven;
        this.spareGiven = spareGiven;
        this.spareProductCode = spareProductCode;
        this.expenses = expenses;
        this.tax = tax;
        this.billAmount = billAmount;
        this.productArrivedOn = productArrivedOn;
        this.productDeliveredOn = productDeliveredOn;
        this.productDelivered = productDelivered;
        this.observation = observation;
        this.billImage = billImage;
        this.faultyProductImage = faultyProductImage;
        this.userDetails = userDetails;
        this.products = products;
        this.payment = payment;
        this.replacementProduct = replacementProduct;
    }

    public FaultyProductEntity(LocalDate issueOccurredOn, String issueDueTo, LocalDate productReceivedOn, Boolean physicalDamages, Boolean underWarranty, Integer timeGiven, Boolean spareGiven, String spareProductCode, Double expenses, Double tax, Double billAmount, LocalDate productArrivedOn, LocalDate productDeliveredOn, Boolean productDelivered, String observation, ImageEntity billImage, ImageEntity faultyProductImage) {
        this.issueOccurredOn = issueOccurredOn;
        this.issueDueTo = issueDueTo;
        this.productReceivedOn = productReceivedOn;
        this.physicalDamages = physicalDamages;
        this.underWarranty = underWarranty;
        this.timeGiven = timeGiven;
        this.spareGiven = spareGiven;
        this.spareProductCode = spareProductCode;
        this.expenses = expenses;
        this.tax = tax;
        this.billAmount = billAmount;
        this.productArrivedOn = productArrivedOn;
        this.productDeliveredOn = productDeliveredOn;
        this.productDelivered = productDelivered;
        this.observation = observation;
        this.billImage = billImage;
        this.faultyProductImage = faultyProductImage;
    }

    public FaultyProductEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public FaultyProductEntity setIssueOccurredOn(LocalDate issueOccurredOn) {
        this.issueOccurredOn = issueOccurredOn;
        return this;
    }

    public FaultyProductEntity setIssueDueTo(String issueDueTo) {
        this.issueDueTo = issueDueTo;
        return this;
    }

    public FaultyProductEntity setProductReceivedOn(LocalDate productReceivedOn) {
        this.productReceivedOn = productReceivedOn;
        return this;
    }

    public FaultyProductEntity setPhysicalDamages(Boolean physicalDamages) {
        this.physicalDamages = physicalDamages;
        return this;
    }

    public FaultyProductEntity setUnderWarranty(Boolean underWarranty) {
        this.underWarranty = underWarranty;
        return this;
    }

    public FaultyProductEntity setTimeGiven(Integer timeGiven) {
        this.timeGiven = timeGiven;
        return this;
    }

    public FaultyProductEntity setSpareGiven(Boolean spareGiven) {
        this.spareGiven = spareGiven;
        return this;
    }

    public FaultyProductEntity setSpareProductCode(String spareProductCode) {
        this.spareProductCode = spareProductCode;
        return this;
    }

    public FaultyProductEntity setExpenses(Double expenses) {
        this.expenses = expenses;
        return this;
    }

    public FaultyProductEntity setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public FaultyProductEntity setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
        return this;
    }

    public FaultyProductEntity setProductArrivedOn(LocalDate productArrivedOn) {
        this.productArrivedOn = productArrivedOn;
        return this;
    }

    public FaultyProductEntity setProductDeliveredOn(LocalDate productDeliveredOn) {
        this.productDeliveredOn = productDeliveredOn;
        return this;
    }

    public FaultyProductEntity setProductDelivered(Boolean productDelivered) {
        this.productDelivered = productDelivered;
        return this;
    }

    public FaultyProductEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public FaultyProductEntity setBillImage(ImageEntity billImage) {
        this.billImage = billImage;
        return this;
    }

    public FaultyProductEntity setFaultyProductImage(ImageEntity faultyProductImage) {
        this.faultyProductImage = faultyProductImage;
        return this;
    }

    public FaultyProductEntity setUserDetails(UserDetailsEntity userDetails) {
        this.userDetails = userDetails;
        return this;
    }

    public FaultyProductEntity setProducts(ProductEntity products) {
        this.products = products;
        return this;
    }

    public FaultyProductEntity setPayment(PaymentEntity payment) {
        this.payment = payment;
        return this;
    }

    public FaultyProductEntity setReplacementProduct(ReplacementProductEntity replacementProduct) {
        this.replacementProduct = replacementProduct;
        return this;
    }
}
