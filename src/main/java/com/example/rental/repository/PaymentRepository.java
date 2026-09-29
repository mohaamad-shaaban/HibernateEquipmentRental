/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental.repository;
import com.example.rental.entity.Payment;
import org.hibernate.SessionFactory;
public class PaymentRepository
extends BaseRepository<Payment, Long> {
public PaymentRepository(
SessionFactory sessionFactory) {
super(
sessionFactory,
Payment.class
);
}
}
