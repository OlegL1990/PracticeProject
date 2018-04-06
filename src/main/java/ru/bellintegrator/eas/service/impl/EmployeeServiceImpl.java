package ru.bellintegrator.eas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.eas.dao.EmployeeDAO;
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.service.EmployeeService;
import ru.bellintegrator.eas.view.EmployeeView;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void save(EmployeeView ev) {
        Employee employee = new Employee();
        employee.setFirstName(ev.getFirstName());
        employee.setMiddleName(ev.getMiddleName());
        employee.setSecondName(ev.getSecondName());
        employee.setPhone(ev.getPhone());
        employee.setPosition(ev.getSecondName());
        employee.setDocCode(employeeDAO.loadDocByCode(ev.getDocCode()));
        employee.setDocNumber(ev.getDocNumber());
        employee.setCitizenshipCode(employeeDAO.loadCountryByCode(ev.getCitizenshipCode()));
        employee.setIdentified(ev.getIdentified());
        employee.setOffice(employeeDAO.loadOfficeById(ev.getOffice()));
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void update(EmployeeView ev) {
        Employee employee = new Employee();
        employee.setId(ev.getId());
        employee.setFirstName(ev.getFirstName());
        employee.setMiddleName(ev.getMiddleName());
        employee.setSecondName(ev.getSecondName());
        employee.setPhone(ev.getPhone());
        employee.setPosition(ev.getSecondName());
        employee.setDocCode(employeeDAO.loadDocByCode(ev.getDocCode()));
        employee.setDocNumber(ev.getDocNumber());
        employee.setCitizenshipCode(employeeDAO.loadCountryByCode(ev.getCitizenshipCode()));
        employee.setIdentified(ev.getIdentified());
        employeeDAO.update(employee);

    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeView loadById(long id) {
        Employee employee = employeeDAO.loadById(id);
        EmployeeView employeeView = new EmployeeView();
        employeeView.setId(employee.getId());
        employeeView.setFirstName(employee.getFirstName());
        employeeView.setMiddleName(employee.getMiddleName());
        employeeView.setSecondName(employee.getSecondName());
        employeeView.setPhone(employee.getPhone());
        employeeView.setPosition(employee.getSecondName());
        employeeView.setDocCode(employee.getDocCode().getCode());
        employeeView.setDocName(employee.getDocCode().getName());
        employeeView.setDocNumber(employee.getDocNumber());
        employeeView.setCitizenshipCode(employee.getCitizenshipiCode().getCode());
        employeeView.setCitizenshipName(employee.getCitizenshipiCode().getName());
        employeeView.setIdentified(employee.getIdentified());
        employeeView.setOffice(employee.getOffice().getId());
        return employeeView;
    }

    @Override
    @Transactional
    public void delete(long id) {
        Employee employee = employeeDAO.loadById(id);
        employeeDAO.delete(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> filter(EmployeeView ev) {
        List<Employee> employee =employeeDAO.loadByFilter(ev.getOffice(),ev.getFirstName(),ev.getMiddleName(),ev.getSecondName(),ev.getPosition(),ev.getDocCode(),ev.getCitizenshipCode());
        return employee;
    }
}
