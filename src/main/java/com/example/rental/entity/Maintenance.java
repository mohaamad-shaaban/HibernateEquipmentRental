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
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(
name = "maintenance_records",
indexes = {
@Index(
name = "idx_maintenance_equipment",
columnList = "equipment_unit_id"
)
}
)
public class Maintenance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)



private Long id;
@ManyToOne(
fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "equipment_unit_id",
nullable = false
)
private EquipmentUnit equipmentUnit;
@Column(name = "start_date", nullable = false)
private LocalDate startDate;
@Column(name = "end_date")
private LocalDate endDate;
@Column(columnDefinition = "TEXT")
private String description;
@Column(
precision = 12,
scale = 2
)
private BigDecimal cost;
@Enumerated(EnumType.STRING)
@Column(nullable = false)
private MaintenanceStatus status;
protected Maintenance() {
}
public Maintenance(
EquipmentUnit equipmentUnit,
LocalDate startDate,
String description,
BigDecimal cost) {
this.equipmentUnit = equipmentUnit;
this.startDate = startDate;
this.description = description;
this.cost = cost;
this.status = MaintenanceStatus.OPEN;
}



public Long getId() {
return id;
}
}