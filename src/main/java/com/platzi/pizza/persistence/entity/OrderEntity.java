package com.platzi.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCostumeer;
    @Column(columnDefinition = "datetime")
    private LocalDateTime date;
    @Column(columnDefinition = "decimal(6,2)")
    private double total;
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String method;
    @Column(name = "additional_notes", length = 200)
    private String addionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer",  insertable = false, updatable = false)
    @JsonIgnore
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @OrderBy("price ASC")
    private List<OrderItemEntity>items;
}
