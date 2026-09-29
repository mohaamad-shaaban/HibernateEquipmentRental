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
@Table(name = "equipment_transfers")
public class EquipmentTransfer {
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
@ManyToOne(
fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "from_branch_id",
nullable = false
)
private Branch fromBranch;
@ManyToOne(



fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "to_branch_id",
nullable = false
)
private Branch toBranch;
@Column(name = "transfer_date", nullable = false)
private LocalDateTime transferDate;
protected EquipmentTransfer() {
}
public EquipmentTransfer(
EquipmentUnit equipmentUnit,
Branch fromBranch,
Branch toBranch) {
this.equipmentUnit = equipmentUnit;
this.fromBranch = fromBranch;
this.toBranch = toBranch;
this.transferDate = LocalDateTime.now();
}
public Long getId() {
return id;
}
}