package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.Country;
import ru.bellintegrator.eas.model.Doc_type;
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.model.Office;

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

    /**
     * Получить Doc_type по идентификатору
     *
     * @param code
     * @return Экземпляр Doc_type с заданным code
     */

    Doc_type loadDocByCode(long code);

    /**
     * Получить Country по идентификатору
     *
     * @param code
     * @return Экземпляр Country с заданным code
     */

    Country loadCountryByCode(long code);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return Экземпляр Office с заданным id
     */

    Office loadOfficeById(long id);

}
