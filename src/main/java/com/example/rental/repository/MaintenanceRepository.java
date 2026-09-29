/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental.repository;
import com.example.rental.entity.Maintenance;
import org.hibernate.SessionFactory;
public class MaintenanceRepository
extends BaseRepository<
Maintenance,
Long> {



public MaintenanceRepository(
SessionFactory sessionFactory) {
super(
sessionFactory,
Maintenance.class
);
}
}