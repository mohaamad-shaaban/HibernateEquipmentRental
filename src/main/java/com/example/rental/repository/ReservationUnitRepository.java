/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental.repository;
import com.example.rental.entity.*;
import org.hibernate.SessionFactory;
public class ReservationUnitRepository
extends BaseRepository<



ReservationUnit,
ReservationUnitId> {
public ReservationUnitRepository(
SessionFactory sessionFactory) {
super(
sessionFactory,
ReservationUnit.class
);
}
}