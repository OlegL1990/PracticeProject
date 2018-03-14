package ru.bellintegrator.eas.service;

import ru.bellintegrator.eas.view.EmployeeView;

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
}
