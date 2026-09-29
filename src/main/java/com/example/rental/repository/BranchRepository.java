/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.repository;

/**
 *
 * @author user
 */
import com.example.rental.entity.Branch;
import org.hibernate.SessionFactory;
public class BranchRepository
extends BaseRepository<Branch, Long> {
public BranchRepository(
SessionFactory sessionFactory) {
super(sessionFactory, Branch.class);
}
}