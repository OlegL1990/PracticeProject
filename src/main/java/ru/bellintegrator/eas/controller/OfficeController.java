package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.eas.service.OfficeService;
import ru.bellintegrator.eas.view.OfficeView;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired(required = true)
    private OfficeService officeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void saveOffice(@RequestBody OfficeView ov) {
        officeService.save(ov);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OfficeView getOffice(@PathVariable("id") long id) {
        return officeService.loadById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteOffice(@RequestBody long id) {
        officeService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateOffice(@RequestBody OfficeView ev) {
        officeService.update(ev);
    }
}