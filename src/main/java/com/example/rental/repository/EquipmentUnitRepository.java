/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental.repository;
import com.example.rental.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.time.LocalDate;
import java.util.List;
public class EquipmentUnitRepository
extends BaseRepository<
EquipmentUnit,
Long> {


public EquipmentUnitRepository(
SessionFactory sessionFactory) {
super(
sessionFactory,
EquipmentUnit.class
);
}
public List<EquipmentUnit>
findAssignableUnits(
Long productId,
Long branchId,
LocalDate startDate,
LocalDate endDate) {
String hql = """
select eu
from EquipmentUnit eu
where eu.product.id = :productId
and eu.branch.id = :branchId
and eu.active = true
and eu.operationalStatus = :available
and not exists (
select ru.id
from ReservationUnit ru
join ru.reservationItem ri
join ri.reservation r
where ru.equipmentUnit = eu
and r.status in (
:confirmed,
:active
)
and r.startDate < :endDate
and r.endDate > :startDate
)


""";
try (Session session =

sessionFactory.openSession()) {
return (List<EquipmentUnit>) session
.createQuery(
hql,
EquipmentUnit.class
)
.setParameter(
"productId",
productId
)
.setParameter(
"branchId",
branchId
)
.setParameter(
"available",
EquipmentOperationalStatus
.AVAILABLE
)
.setParameter(
"confirmed",
ReservationStatus.CONFIRMED
)
.setParameter(
"active",
ReservationStatus.ACTIVE
)
.setParameter(
"startDate",
startDate
)
.setParameter(
"endDate",
endDate
)



.getResultList();
}
}
}