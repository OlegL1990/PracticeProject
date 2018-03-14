package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.EmployeeDAO;
import ru.bellintegrator.eas.model.Employee;

import javax.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Employee loadById(long id){
        return em.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        em.merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        em.remove(employee);
    }

    //@Override
    //List<Employee> list(long officeid,String firstName,String middleName,String lastName,String position,int docCode,int citizenshipCode);
    ////сделать с помощью Criteria API
}
