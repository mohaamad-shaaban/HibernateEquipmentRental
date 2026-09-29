/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.entity;

/**
 *
 * @author user
 */
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(
name = "reservation_items",
indexes = {
@Index(
name = "idx_reservation_item_reservation",
columnList = "reservation_id"
)
}
)
public class ReservationItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(
fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "reservation_id",
nullable = false
)
private Reservation reservation;
@ManyToOne(
fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "product_id",
nullable = false
)
private Product product;
@Column(nullable = false)



private int quantity;
@Column(
name = "daily_rate",
nullable = false,
precision = 12,
scale = 2
)
private BigDecimal dailyRate;
protected ReservationItem() {
}
public ReservationItem(
Reservation reservation,
Product product,
int quantity,
BigDecimal dailyRate) {
if (quantity <= 0) {
throw new IllegalArgumentException(
"Quantity must be greater than zero."
);
}
this.reservation = reservation;
this.product = product;
this.quantity = quantity;
/*
* Snapshot of the price at reservation time.
*/
this.dailyRate = dailyRate;
}
public Long getId() {
return id;
}
public int getQuantity() {
return quantity;
}
}