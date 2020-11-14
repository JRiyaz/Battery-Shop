package com.batteryshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "files")
public class FileEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String fileName;

    @Column
    private String fileType;

    @Column
    @Lob
    private byte[] file;

    public FileEntity(String fileName, String fileType, byte[] file) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.file = file;
    }

    public static String BytesToImageConverter(byte[] imageInBytes) {

        return imageInBytes != null && imageInBytes.length > 0 ? Base64.getEncoder().encodeToString(imageInBytes) : "";
    }
}
