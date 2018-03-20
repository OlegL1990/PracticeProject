package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.eas.service.EmployeeService;
import ru.bellintegrator.eas.view.EmployeeView;

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

    @RequestMapping(value="/delete",method= RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public void deleteEmployee(@RequestBody long id){
        employeeService.delete(id);
    }

    @RequestMapping(value="/update",method= RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public void updateEmployee(@RequestBody EmployeeView ev){
        employeeService.update(ev);
    }

}
