/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.repository;

/**
 *
 * @author user
 */
import com.example.rental.entity.Customer;
import org.hibernate.SessionFactory;
public class CustomerRepository
extends BaseRepository<Customer, Long> {
public CustomerRepository(



SessionFactory sessionFactory) {
super(sessionFactory, Customer.class);
}
}