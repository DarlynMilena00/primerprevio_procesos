package com.procesos.primerprevio_procesos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_product")
    private String name;
    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;
}
