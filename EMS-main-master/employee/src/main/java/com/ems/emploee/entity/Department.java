package com.ems.emploee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="depart_name")
    private String name;
    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employs;
}
