/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santi;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sant821
 */
@Stateless
public class EmployeeDAO {

    @PersistenceContext(name = "database-crud-ant-PU")
    private EntityManager em;

    private int getNextId() {
        Query query = em.createNativeQuery("SELECT employee_sec.nextval FROM dual");
        return ((BigDecimal) query.getSingleResult()).intValue();
    }

    public List<Employee> getAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    public void create(Employee e) {
        e.setId(getNextId());
        em.persist(e);
    }

    public void update(Employee e) throws Exception {
        Employee employee = getById(e.getId());

        if (employee == null) {
            throw new Exception("The person with id " + e.getId() + " does not exists!");
        }
        
        em.merge(e);
    }
    
    public void destroy(int id) throws Exception {
        Employee employee = getById(id);

        if (employee == null) {
            throw new Exception("The person with id " + id + " does not exists!");
        }
        
        em.remove(employee);
    }
}
