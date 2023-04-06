package com.ems.emploee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column private int id;
    @Column(name="employee_present")
    private Boolean isEmplPresent;
    @Column(name="date")
    private Date date;
    @Column(name="time_in")
    private int timeIn;
    @Column(name="time_out")
    private int timeOut;
    @ManyToOne
    @JoinColumn (name="employee_id")
    private Employee employ;
}
