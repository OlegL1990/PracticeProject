package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.EmployeeDAO;
import ru.bellintegrator.eas.model.Country;
import ru.bellintegrator.eas.model.Doc_type;
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.model.Office;

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
    public Doc_type loadDocByCode(long code) {
        return em.find(Doc_type.class, code);
    }

    @Override
    public Country loadCountryByCode(long code) {
        return em.find(Country.class, code);
    }

    @Override
    public void delete(Employee employee) {
        em.remove(employee);
    }

    @Override
    public Office loadOfficeById(long id) {
        return em.find(Office.class, id);
    }
    //@Override
    //List<Employee> list(long officeid,String firstName,String middleName,String lastName,String position,int docCode,int citizenshipCode);
    ////сделать с помощью Criteria API
}
