package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> saveEmployee(@RequestBody EmployeeView ev){
        employeeService.save(ev);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeView> getEmployee(@PathVariable("id") long id){
        return new ResponseEntity<EmployeeView>(employeeService.loadById(id),HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteEmployee(@RequestBody long id){
        employeeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/update",method= RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeView ev){
        employeeService.update(ev);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/list",method= RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Employee>> filterEmployee(@RequestBody EmployeeView ev){
        return new ResponseEntity<List<Employee>>(employeeService.filter(ev),HttpStatus.OK);
    }

}
