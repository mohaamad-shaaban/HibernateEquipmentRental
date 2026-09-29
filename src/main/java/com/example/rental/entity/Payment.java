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
import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
public class Payment {
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
@Column(
nullable = false,
precision = 12,
scale = 2
)
private BigDecimal amount;
@Column(name = "payment_date", nullable = false)
private LocalDateTime paymentDate;
@Enumerated(EnumType.STRING)
@Column(name = "payment_method", nullable = false)
private PaymentMethod paymentMethod;
@Enumerated(EnumType.STRING)
@Column(nullable = false)
private PaymentStatus status;
private String reference;
protected Payment() {
}
public Payment(
Reservation reservation,



BigDecimal amount,
PaymentMethod paymentMethod,
PaymentStatus status,
String reference) {
this.reservation = reservation;
this.amount = amount;
this.paymentMethod = paymentMethod;
this.status = status;
this.reference = reference;
this.paymentDate = LocalDateTime.now();
}
public Long getId() {
return id;
}
}