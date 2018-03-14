package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.Employee;

public interface EmployeeDAO {
    //List<Employee> list(long officeid,String firstName,String middleName,String lastName,String position,int docCode,int citizenshipCode);

    /**
     * Получить Employee по идентификатору
     *
     * @param id
     * @return Экземпляр Employee с заданным id
     */
    Employee loadById(long id);

    /**
     * Сохранить в бд переданный экземпляр Employee
     *
     * @param employee
     */
    void save(Employee employee);

    /**
     * Обновнить в бд переданный экземпляр Employee
     *
     * @param employee
     */
    void update(Employee employee);

    /**
     * Удалить из бд переданный экземпляр Employee
     *
     * @param employee
     */
    void delete(Employee employee);
}
