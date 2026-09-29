/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental.repository;
import com.example.rental.entity.ReservationItem;
import org.hibernate.SessionFactory;
public class ReservationItemRepository
extends BaseRepository<
ReservationItem,
Long> {
public ReservationItemRepository(
SessionFactory sessionFactory) {
super(
sessionFactory,
ReservationItem.class
);
}
}