package com.batteryshop.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@DynamicUpdate
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"productImage", "products"})
@Table(name = "complaints")
public class ComplaintsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Temporal(TemporalType.DATE)
    @Column(name = "issue_occurred_on")
    private LocalDate issueOccurredOn;

    @Column(name = "issue_due_to")
    private String issueDueTo;

    @Column(name = "under_warranty")
    private Boolean underWarranty;

    @Column(name = "any_physical_damages")
    private Boolean anyPhysicalDamages;

    @Column(length = 1000)
    private String observation;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ImageEntity.class)
    @JoinColumn(name = "image_id")
    private ImageEntity productImage;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = ProductEntity.class)
    @JoinColumn(name = "product_id")
    private ProductEntity products;

    public ComplaintsEntity(LocalDate issueOccurredOn, String issueDueTo, Boolean underWarranty, Boolean anyPhysicalDamages, String observation, ImageEntity productImage, ProductEntity products) {
        this.issueOccurredOn = issueOccurredOn;
        this.issueDueTo = issueDueTo;
        this.underWarranty = underWarranty;
        this.anyPhysicalDamages = anyPhysicalDamages;
        this.observation = observation;
        this.productImage = productImage;
        this.products = products;
    }

    public ComplaintsEntity(LocalDate issueOccurredOn, String issueDueTo, Boolean underWarranty, Boolean anyPhysicalDamages, ImageEntity productImage) {
        this.issueOccurredOn = issueOccurredOn;
        this.issueDueTo = issueDueTo;
        this.underWarranty = underWarranty;
        this.anyPhysicalDamages = anyPhysicalDamages;
        this.productImage = productImage;
    }

    public ComplaintsEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public ComplaintsEntity setIssueOccurredOn(LocalDate issueOccurredOn) {
        this.issueOccurredOn = issueOccurredOn;
        return this;
    }

    public ComplaintsEntity setIssueDueTo(String issueDueTo) {
        this.issueDueTo = issueDueTo;
        return this;
    }

    public ComplaintsEntity setUnderWarranty(Boolean underWarranty) {
        this.underWarranty = underWarranty;
        return this;
    }

    public ComplaintsEntity setAnyPhysicalDamages(Boolean anyPhysicalDamages) {
        this.anyPhysicalDamages = anyPhysicalDamages;
        return this;
    }

    public ComplaintsEntity setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public ComplaintsEntity setProductImage(ImageEntity productImage) {
        this.productImage = productImage;
        return this;
    }

    public ComplaintsEntity setProducts(ProductEntity products) {
        this.products = products;
        return this;
    }
}
