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
import java.time.LocalDateTime;
@Entity
@Table(
name = "reservation_units",
indexes = {
@Index(
name = "idx_reservation_unit_equipment",
columnList = "equipment_unit_id"
)
}
)
public class ReservationUnit {
@EmbeddedId
private ReservationUnitId id;
@MapsId("reservationItemId")
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(
name = "reservation_item_id",


nullable = false
)
private ReservationItem reservationItem;
@MapsId("equipmentUnitId")
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(
name = "equipment_unit_id",
nullable = false
)
private EquipmentUnit equipmentUnit;
@Column(name = "assigned_at", nullable = false)
private LocalDateTime assignedAt;
protected ReservationUnit() {
}
public ReservationUnit(
ReservationItem reservationItem,
EquipmentUnit equipmentUnit) {
this.reservationItem = reservationItem;
this.equipmentUnit = equipmentUnit;
this.id = new ReservationUnitId(
reservationItem.getId(),
equipmentUnit.getId()
);
this.assignedAt = LocalDateTime.now();
}
public ReservationUnitId getId() {
return id;
}
}