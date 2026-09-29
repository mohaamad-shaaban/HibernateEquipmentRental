/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.repository;

import com.example.rental.entity.Product;
import org.hibernate.SessionFactory;

public class ProductRepository extends BaseRepository<Product, Long> {

    public ProductRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Product.class);
    }
}