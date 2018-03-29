package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.EmployeeDAO;
import ru.bellintegrator.eas.model.Country;
import ru.bellintegrator.eas.model.Doc_type;
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

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
    @Override
    public List<Employee> loadByFilter(long office,String firstName){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = cq.from(Employee.class);

        Predicate predicate = cb.conjunction();
        //office

            Predicate pa = cb.equal(employeeRoot.join("office").get("id"), office);
            predicate = cb.and(predicate, pa);

        //lastName
        if (firstName != null) {
            Predicate p = cb.equal(employeeRoot.get("firstName"), firstName);
            predicate = cb.and(predicate, p);
        }
        cq.where(predicate);
        List<Employee> result = em.createQuery(cq).getResultList();
        return result;
    }
    //@Override
    //List<Employee> list(long officeid,String firstName,String middleName,String lastName,String position,int docCode,int citizenshipCode);
    ////сделать с помощью Criteria API
}
