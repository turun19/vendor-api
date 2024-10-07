package com.example.technicaltestptsisi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;
    @Column(name = "name")
    private String nameVendor;
}
