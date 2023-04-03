package com.ems.emploee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="gender")
    private  String gender;
    @Column(name="age")
    private int age;
    @Column(name="designation")
    private String designation;
    @Column(name="salary")
    private double salary;
    @ManyToOne
    @JoinColumn (name="id")
    private Department department;
    @OneToMany(mappedBy = "employ")
    private List<Attendance>attendanceList;

}
