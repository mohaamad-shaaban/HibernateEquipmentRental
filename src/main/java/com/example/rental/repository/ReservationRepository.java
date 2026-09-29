/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental.repository;
import com.example.rental.entity.Reservation;
import org.hibernate.SessionFactory;
public class ReservationRepository



extends BaseRepository<Reservation, Long> {
public ReservationRepository(
SessionFactory sessionFactory) {
super(
sessionFactory,
Reservation.class
);
}
}