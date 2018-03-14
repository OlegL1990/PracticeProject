package ru.bellintegrator.eas.service;

import ru.bellintegrator.eas.view.EmployeeView;

public interface EmployeeService {
    EmployeeView loadById(long id);
    void save(EmployeeView ev);
    void update(EmployeeView ev);
    void delete(long id);
}
