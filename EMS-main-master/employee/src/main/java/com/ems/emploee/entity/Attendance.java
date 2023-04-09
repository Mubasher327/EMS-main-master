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
    @Column private long id;
    @Column(name="employee_present")
    private Boolean isEmplPresent;
    @Column(name="date")
    private Date date;
    @Column(name="time_in")
    private String  timeIn;
    @Column(name="time_out")
    private String timeOut;
    @ManyToOne
    @JoinColumn (name="employee_id")
    private Employee employ;
}
