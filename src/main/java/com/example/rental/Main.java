/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.example.rental;
import com.example.rental.config.HibernateUtil;
import com.example.rental.entity.*;
import com.example.rental.repository.*;
import org.hibernate.SessionFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.example.rental.repository.CategoryRepository;
import com.example.rental.repository.ProductRepository;
public class Main {
public static void main(String[] args) {
SessionFactory sessionFactory =
HibernateUtil
.getSessionFactory();

/*
* Create repositories.
*/
CustomerRepository customerRepository =
new CustomerRepository(
sessionFactory
);
BranchRepository branchRepository =
new BranchRepository(
sessionFactory
);



CategoryRepository categoryRepository =
new CategoryRepository(
sessionFactory
);
ProductRepository productRepository =
new ProductRepository(
sessionFactory
);
EquipmentUnitRepository
equipmentRepository =
new EquipmentUnitRepository(
sessionFactory
);
ReservationRepository
reservationRepository =
new ReservationRepository(
sessionFactory
);
ReservationItemRepository
reservationItemRepository =
new ReservationItemRepository(
sessionFactory
);
ReservationUnitRepository
reservationUnitRepository =
new ReservationUnitRepository(
sessionFactory
);
PaymentRepository paymentRepository =
new PaymentRepository(
sessionFactory
);
MaintenanceRepository
maintenanceRepository =
new MaintenanceRepository(
sessionFactory
);
try {



/*

* Using a suffix allows this test to be
* executed repeatedly without violating
* unique constraints.
*/

String suffix =
String.valueOf(
System.currentTimeMillis()
);
/*
* STEP 1
* Create branch
*/

Branch branch =
branchRepository.create(
new Branch(
"Beirut Main Branch "
+ suffix,
"Beirut",
"Beirut"
)
);
System.out.println(
"Branch created. ID = "
+ branch.getId()
);
/*
* STEP 2
* Create category
*/

Category category =
categoryRepository.create(
new Category(
"Laptops-" + suffix
)
);
/*
* STEP 3
* Create product
*/

Product laptop =
productRepository.create(
new Product(
category,


"Dell Latitude 5540",
"Dell",
"Latitude 5540",
new BigDecimal("20.00")
)
);
/*
* STEP 4
* Create physical equipment
*/

EquipmentUnit equipment =
equipmentRepository.create(
new EquipmentUnit(
laptop,
branch,
"SERIAL-" + suffix,
"LAP-" + suffix,
LocalDate.now()
.minusMonths(6)
)
);
System.out.println(
"Equipment created: "
+ equipment.getAssetCode()
);
/*
* STEP 5
* Create customer
*/

Customer customer =
customerRepository.create(
new Customer(
"Ahmad",
"Khalil",
"ahmad."
+ suffix
+ "@example.com",
"70123456"
)
);
/*
* STEP 6
* Reservation dates
*/



LocalDate startDate =
LocalDate.now()
.plusDays(7);
LocalDate endDate =
startDate.plusDays(3);
Reservation reservation =
reservationRepository.create(
new Reservation(
customer,
branch,
startDate,
endDate
)
);
/*
* STEP 7
* Create reservation item
*
* Important:
* snapshot current price.
*/

ReservationItem item =
reservationItemRepository
.create(
new ReservationItem(
reservation,
laptop,
1,
laptop.getDailyRate()
)
);

/*

* Before assigning physical equipment,
* check availability.
*/

List<EquipmentUnit>
availableBeforeAssignment =
equipmentRepository
.findAssignableUnits(
laptop.getId(),
branch.getId(),
startDate,
endDate
);



System.out.println(
"Available before assignment = "
+ availableBeforeAssignment
.size()

);
/*
* STEP 8
* Assign the actual laptop.
*/

ReservationUnit assignment =
new ReservationUnit(
item,
equipment
);
reservationUnitRepository
.create(assignment);
/*

* Check availability again.
*/

List<EquipmentUnit>
availableAfterAssignment =
equipmentRepository
.findAssignableUnits(
laptop.getId(),
branch.getId(),
startDate,
endDate
);
System.out.println(
"Available after assignment = "
+ availableAfterAssignment
.size()

);
/*
* STEP 9
* Add payment.
*/

Payment payment =
paymentRepository.create(
new Payment(
reservation,
new BigDecimal("60.00"),



PaymentMethod.CARD,
PaymentStatus.PAID,
"PAY-" + suffix
)
);
System.out.println(
"Payment created. ID = "
+ payment.getId()
);
/*
* STEP 10
* Read equipment from database.
*/

EquipmentUnit storedEquipment =
equipmentRepository
.findById(
equipment.getId()
)
.orElseThrow();
System.out.println(
"\nStatus before update = "
+ storedEquipment
.getOperationalStatus()

);
/*
* STEP 11
* Change equipment condition.
*/

storedEquipment
.setOperationalStatus(
EquipmentOperationalStatus
.MAINTENANCE
);
equipmentRepository
.update(storedEquipment);
/*
* STEP 12
* Create maintenance history.
*/

Maintenance maintenance =
new Maintenance(
storedEquipment,



LocalDate.now(),
"Keyboard requires replacement",
new BigDecimal("35.00")
);
maintenanceRepository
.create(maintenance);
/*
* STEP 13
* Reload the row from PostgreSQL.
*/

EquipmentUnit verifiedEquipment =
equipmentRepository
.findById(
equipment.getId()
)
.orElseThrow();
System.out.println(
"Status after update = "
+ verifiedEquipment
.getOperationalStatus()

);
/*

* Additional verification.
*/

System.out.println(
"\nCustomers in database: "
+ customerRepository
.findAll()
.size()

);
System.out.println(
"Products in database: "
+ productRepository
.findAll()
.size()

);
System.out.println(
"Reservations in database: "
+ reservationRepository
.findAll()
.size()

);



System.out.println(
"\nTEST COMPLETED SUCCESSFULLY"
);
} finally {
HibernateUtil.shutdown();
}
}
}