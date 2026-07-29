package com.platzi.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Setter
@Getter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @Column(name = "id_item")
    private Integer idItem;
    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;
    @Column(name = "id_pizza")
    private Integer idPizza;
    @Column(columnDefinition = "decimal(2,1)", nullable = false)
    private double quantity;
    @Column(columnDefinition = "decimal(5,2)", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    @JsonIgnore
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaEntity pizza;
}
