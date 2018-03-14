package ru.bellintegrator.eas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.eas.dao.EmployeeDAO;
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.service.EmployeeService;
import ru.bellintegrator.eas.view.EmployeeView;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void save(EmployeeView ev) {
        Employee employee = new Employee();
        employee.setFirstName(ev.getFirstName());
        employee.setMiddleName(ev.getMiddleName());
        employee.setSecondName(ev.getSecondName());
        employee.setPhone(ev.getPhone());
        employee.setPosition(ev.getSecondName());
        employee.setDocid(ev.getDocid());
        employee.setDocDate(ev.getDocDate());
        employee.setDocNumber(ev.getDocNumber());
        employee.setCitizenshipid(ev.getCitizenshipid());
        employee.setIdentified(ev.getIdentified());
        employeeDAO.save(employee);
    }

    @Override
    public void update(EmployeeView ev) {
        Employee employee = new Employee();
        employee.setId(ev.getId());
        employee.setFirstName(ev.getFirstName());
        employee.setMiddleName(ev.getMiddleName());
        employee.setSecondName(ev.getSecondName());
        employee.setPhone(ev.getPhone());
        employee.setPosition(ev.getSecondName());
        employee.setDocid(ev.getDocid());
        employee.setDocDate(ev.getDocDate());
        employee.setDocNumber(ev.getDocNumber());
        employee.setCitizenshipid(ev.getCitizenshipid());
        employee.setIdentified(ev.getIdentified());
        employeeDAO.update(employee);

    }

    @Override
    public EmployeeView loadById(long id) {
        Employee employee = employeeDAO.loadById(id);
        EmployeeView employeeView = new EmployeeView();
        employeeView.setId(employee.getId());
        employeeView.setFirstName(employee.getFirstName());
        employeeView.setMiddleName(employee.getMiddleName());
        employeeView.setSecondName(employee.getSecondName());
        employeeView.setPhone(employee.getPhone());
        employeeView.setPosition(employee.getSecondName());
        employeeView.setDocid(employee.getDocid());
        employeeView.setDocDate(employee.getDocDate());
        employeeView.setDocNumber(employee.getDocNumber());
        employeeView.setCitizenshipid(employee.getCitizenshipid());
        employeeView.setIdentified(employee.getIdentified());

        return employeeView;
    }

    @Override
    public void delete(long id) {
        Employee employee = employeeDAO.loadById(id);
        employeeDAO.delete(employee);
    }
}
