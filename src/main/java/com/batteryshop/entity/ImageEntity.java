package com.batteryshop.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "images")
public class ImageEntity implements Serializable {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private byte[] image;

    @Getter
    private String name;

    @Getter
    private String type;

    @Getter
    private Double size;

    @Getter
    @Column(name = "whose_image")
    private String whoseImage;

    public ImageEntity(byte[] image, String name, String type, Double size, String whoseImage) {
        this.image = image;
        this.name = name;
        this.type = type;
        this.size = size;
        this.whoseImage = whoseImage;
    }

    public static String BytesToImageConverter(byte[] imageInBytes) {

        return imageInBytes != null && imageInBytes.length > 0 ? Base64.getEncoder().encodeToString(imageInBytes) : "";
    }

    public ImageEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public ImageEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ImageEntity setType(String type) {
        this.type = type;
        return this;
    }

    public ImageEntity setSize(Double size) {
        this.size = size;
        return this;
    }

    public ImageEntity setWhoseImage(String whoseImage) {
        this.whoseImage = whoseImage;
        return this;
    }

    public String getImage() {
        return Base64.getEncoder().encodeToString(image);
    }

    public ImageEntity setImage(byte[] image) {
        this.image = image;
        return this;
    }
}
