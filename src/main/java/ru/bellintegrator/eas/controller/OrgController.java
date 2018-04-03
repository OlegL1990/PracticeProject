package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.eas.model.Org;
import ru.bellintegrator.eas.service.OrgService;
import ru.bellintegrator.eas.view.OrgView;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired(required = true)
    private OrgService orgService;


    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void saveOffice(@RequestBody OrgView orv) {
        orgService.save(orv);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OrgView getOffice(@PathVariable("id") long id) {
        return orgService.loadById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteOffice(@RequestBody long id) {
        orgService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateOffice(@RequestBody OrgView orv) {
        orgService.update(orv);
    }


}
