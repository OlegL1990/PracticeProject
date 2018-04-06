package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.eas.model.Office;
import ru.bellintegrator.eas.model.Org;
import ru.bellintegrator.eas.service.OfficeService;
import ru.bellintegrator.eas.view.OfficeView;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired(required = true)
    private OfficeService officeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> saveOffice(@RequestBody OfficeView ov) {
        officeService.save(ov);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OfficeView> getOffice(@PathVariable("id") long id) {
        return new ResponseEntity<OfficeView>(officeService.loadById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteOffice(@RequestBody long id) {
        officeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateOffice(@RequestBody OfficeView ev) {
        officeService.update(ev);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/list",method= RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Office>> filterOffice(@RequestBody OfficeView ov){
        return new ResponseEntity<List<Office>>(officeService.filter(ov),HttpStatus.OK);
    }
}