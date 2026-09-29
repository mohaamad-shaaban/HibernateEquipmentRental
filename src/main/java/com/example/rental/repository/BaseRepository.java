/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rental.repository;

/**
 *
 * @author user
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Optional;
public class BaseRepository<T, ID> {
protected final SessionFactory sessionFactory;
private final Class<T> entityClass;
public BaseRepository(
SessionFactory sessionFactory,
Class<T> entityClass) {
this.sessionFactory = sessionFactory;
this.entityClass = entityClass;
}



public T create(T entity) {
Transaction transaction = null;
try (Session session =

sessionFactory.openSession()) {
transaction =
session.beginTransaction();
session.persist(entity);
transaction.commit();
return entity;
} catch (RuntimeException exception) {
if (transaction != null) {
transaction.rollback();
}
throw exception;
}
}
public Optional<T> findById(ID id) {
try (Session session =

sessionFactory.openSession()) {
return Optional.ofNullable(
session.find(entityClass, id)
);
}
}
public List<T> findAll() {
try (Session session =

sessionFactory.openSession()) {
String hql =
"from " +
entityClass.getSimpleName();
return session



.createQuery(hql, entityClass)
.getResultList();

}
}
public T update(T entity) {
Transaction transaction = null;
try (Session session =

sessionFactory.openSession()) {
transaction =
session.beginTransaction();
T merged =
session.merge(entity);
transaction.commit();
return merged;
} catch (RuntimeException exception) {
if (transaction != null) {
transaction.rollback();
}
throw exception;
}
}
public void delete(ID id) {
Transaction transaction = null;
try (Session session =

sessionFactory.openSession()) {
transaction =
session.beginTransaction();
T entity =
session.find(entityClass, id);
if (entity != null) {
session.remove(entity);
}



transaction.commit();
} catch (RuntimeException exception) {
if (transaction != null) {
transaction.rollback();
}
throw exception;
}
}
}