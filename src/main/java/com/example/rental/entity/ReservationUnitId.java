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
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ReservationUnitId
implements Serializable {
@Column(name = "reservation_item_id")
private Long reservationItemId;
@Column(name = "equipment_unit_id")
private Long equipmentUnitId;
protected ReservationUnitId() {
}
public ReservationUnitId(
Long reservationItemId,
Long equipmentUnitId) {
this.reservationItemId = reservationItemId;
this.equipmentUnitId = equipmentUnitId;
}
@Override
public boolean equals(Object object) {
if (this == object) {
return true;
}
if (!(object instanceof ReservationUnitId other)) {
return false;
}
return Objects.equals(
reservationItemId, other.reservationItemId)
&&



Objects.equals(
equipmentUnitId,
other.equipmentUnitId
);

}
@Override
public int hashCode() {
return Objects.hash(
reservationItemId,
equipmentUnitId
);
}
}