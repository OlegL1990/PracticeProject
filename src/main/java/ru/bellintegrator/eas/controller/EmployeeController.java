package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.service.EmployeeService;
import ru.bellintegrator.eas.view.EmployeeView;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired(required=true)
    private EmployeeService employeeService;

    @RequestMapping(value="/save",method= RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public void saveEmployee(@RequestBody EmployeeView ev){
        employeeService.save(ev);
    }

    @GetMapping(value="/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
    public EmployeeView getEmployee(@PathVariable("id") long id){
        return employeeService.loadById(id);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public void deleteEmployee(@RequestBody long id){
        employeeService.delete(id);
    }

    @RequestMapping(value="/update",method= RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public void updateEmployee(@RequestBody EmployeeView ev){
        employeeService.update(ev);
    }

    @RequestMapping(value="/filter",method= RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> filterEmployee(@RequestBody EmployeeView ev){
        return employeeService.filter(ev);
    }

}
