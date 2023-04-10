package com.ems.emploee.entity;

import com.ems.emploee.model.EmployeeModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="phone_no")
    private String phoneNo;
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
