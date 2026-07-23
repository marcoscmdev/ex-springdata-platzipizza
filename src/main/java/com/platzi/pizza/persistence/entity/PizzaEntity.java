package com.platzi.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;
    @Column(length = 30, unique = true)
    private String name;
    @Column(length = 150)
    private String description;
    @Column(columnDefinition = "decimal(5,2)")
    private double price;
    @Column(columnDefinition = "TINYINT")
    private boolean vegetarian;
    @Column(columnDefinition = "TINYINT")
    private boolean vegan;
    @Column(columnDefinition = "TINYINT", nullable = false)
    private boolean available;

}
