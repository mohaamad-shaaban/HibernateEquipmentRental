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
import java.time.LocalDate;
@Entity
@Table(
name = "equipment_units",



indexes = {
@Index(
name = "idx_equipment_product_branch_status",
columnList =
"product_id, branch_id, operational_status"
)
},
uniqueConstraints = {
@UniqueConstraint(
name = "uk_equipment_serial",
columnNames = "serial_number"
),
@UniqueConstraint(
name = "uk_equipment_asset_code",
columnNames = "asset_code"
)
}
)
public class EquipmentUnit {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(
fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "product_id",
nullable = false
)
private Product product;
@ManyToOne(
fetch = FetchType.LAZY,
optional = false
)
@JoinColumn(
name = "branch_id",
nullable = false
)
private Branch branch;
@Column(name = "serial_number", nullable = false)
private String serialNumber;



@Column(name = "asset_code", nullable = false)
private String assetCode;
@Enumerated(EnumType.STRING)
@Column(
name = "operational_status",
nullable = false
)
private EquipmentOperationalStatus operationalStatus;
@Column(name = "purchase_date")
private LocalDate purchaseDate;
@Column(nullable = false)
private boolean active;
protected EquipmentUnit() {
}
public EquipmentUnit(
Product product,
Branch branch,
String serialNumber,
String assetCode,
LocalDate purchaseDate) {
this.product = product;
this.branch = branch;
this.serialNumber = serialNumber;
this.assetCode = assetCode;
this.purchaseDate = purchaseDate;
this.operationalStatus =
EquipmentOperationalStatus.AVAILABLE;
this.active = true;
}
public Long getId() {
return id;
}
public String getAssetCode() {
return assetCode;
}
public EquipmentOperationalStatus



getOperationalStatus() {
return operationalStatus;
}
public void setOperationalStatus(
EquipmentOperationalStatus status) {
this.operationalStatus = status;
}
}