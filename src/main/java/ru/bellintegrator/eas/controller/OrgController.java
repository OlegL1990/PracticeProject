package ru.bellintegrator.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> saveOrg(@RequestBody OrgView orv) {
        orgService.save(orv);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrgView> getOrg(@PathVariable("id") long id) {
        OrgView orv = orgService.loadById(id);
        return new ResponseEntity<OrgView>(orv, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteOrg(@RequestBody long id) {
        orgService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateOrg(@RequestBody OrgView orv) {
        orgService.update(orv);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/list",method= RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Org>> filterOrg(@RequestBody OrgView orv){
        List<Org> list = orgService.filter(orv);
        return new ResponseEntity<List<Org>>(list,HttpStatus.OK);
    }
}
