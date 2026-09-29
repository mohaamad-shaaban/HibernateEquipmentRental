/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.repository;

import com.example.rental.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryRepository extends BaseRepository<Category, Long> {

    public CategoryRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Category.class);
    }
}
