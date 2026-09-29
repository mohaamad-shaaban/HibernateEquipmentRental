/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.config;

/**
 *
 * @author user
 */
import com.example.rental.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public final class HibernateUtil {
private static final SessionFactory SESSION_FACTORY =
buildSessionFactory();
private HibernateUtil() {
}
private static SessionFactory buildSessionFactory() {
try {
Configuration configuration =
new Configuration()
.configure();

configuration
.addAnnotatedClass(Customer.class)
.addAnnotatedClass(Branch.class)
.addAnnotatedClass(Category.class)
.addAnnotatedClass(Product.class)
.addAnnotatedClass(EquipmentUnit.class)
.addAnnotatedClass(Reservation.class)
.addAnnotatedClass(ReservationItem.class)
.addAnnotatedClass(ReservationUnit.class)
.addAnnotatedClass(Payment.class)
.addAnnotatedClass(Maintenance.class)
.addAnnotatedClass(
EquipmentTransfer.class
);
return configuration
.buildSessionFactory();
} catch (Exception exception) {
System.err.println(



"Unable to initialize Hibernate."
);
exception.printStackTrace();
throw new ExceptionInInitializerError(
exception
);
}
}
public static SessionFactory
getSessionFactory() {
return SESSION_FACTORY;
}
public static void shutdown() {
if (!SESSION_FACTORY.isClosed()) {
SESSION_FACTORY.close();
}
}
}