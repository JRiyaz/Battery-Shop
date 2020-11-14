package com.batteryshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String email;

    @Column
    private String mobile;

    @Column
    private String grade;

    public Student(String name, String gender, String email, String mobile, String grade) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.grade = grade;
    }
}
