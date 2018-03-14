package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.Employee;

public interface EmployeeDAO {
    //List<Employee> list(long officeid,String firstName,String middleName,String lastName,String position,int docCode,int citizenshipCode);
    Employee loadById(long id);
    void save(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}
