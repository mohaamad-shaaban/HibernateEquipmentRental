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
@Entity
@Table(
name = "categories",
uniqueConstraints = {
@UniqueConstraint(
name = "uk_category_name",
columnNames = "name"
)
}
)
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String name;
protected Category() {



}
public Category(String name) {
this.name = name;
}
public Long getId() {
return id;
}
public String getName() {
return name;
}
}