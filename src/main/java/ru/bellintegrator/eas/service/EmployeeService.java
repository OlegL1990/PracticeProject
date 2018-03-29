package ru.bellintegrator.eas.service;

import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.view.EmployeeView;

import java.util.List;

public interface EmployeeService {

    /**
     * Получить EmployeeView по идентификатору
     *
     * @param id
     * @return Экземпляр EmployeeView с заданным id
     */
    EmployeeView loadById(long id);

    /**
     * Сохранить  EmployeeView
     *
     * @param ev
     */
    void save(EmployeeView ev);

    /**
     * Обновнить  EmployeeView
     *
     * @param ev
     */
    void update(EmployeeView ev);

    /**
     * Удалить Employee по идентификатору
     *
     * @param id
     */
    void delete(long id);

    List<Employee> filter(EmployeeView ev);
}
