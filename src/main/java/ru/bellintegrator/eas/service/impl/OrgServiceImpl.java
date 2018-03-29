package ru.bellintegrator.eas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.eas.dao.OrgDAO;
import ru.bellintegrator.eas.model.Org;
import ru.bellintegrator.eas.service.OrgService;
import ru.bellintegrator.eas.view.OrgView;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgDAO orgDAO;

    @Override
    @Transactional(readOnly = true)
    public OrgView loadById(long id) {
       Org org =  orgDAO.loadById(id);
       OrgView orv = new OrgView();
       orv.setId(org.getId());
       orv.setName(org.getName());
       orv.setFullName(org.getFullName());
       orv.setAddress(org.getAddress());
       orv.setPhone(org.getPhone());
       orv.setInn(org.getInn());
       orv.setKpp(org.getKpp());
       orv.setActive(org.getActive());
       return orv;
    }

    @Override
    @Transactional
    public void save(OrgView orv) {
        Org org = new Org();
        org.setName(orv.getName());
        org.setFullName(orv.getFullName());
        org.setAddress(orv.getAddress());
        org.setPhone(orv.getPhone());
        org.setInn(orv.getInn());
        org.setKpp(orv.getKpp());
        org.setActive(orv.getActive());
        orgDAO.save(org);
    }

    @Override
    @Transactional
    public void update(OrgView orv) {
        Org org = new Org();
        org.setId(orv.getId());
        org.setName(orv.getName());
        org.setFullName(orv.getFullName());
        org.setAddress(orv.getAddress());
        org.setPhone(orv.getPhone());
        org.setInn(orv.getInn());
        org.setKpp(orv.getKpp());
        org.setActive(orv.getActive());
        orgDAO.update(org);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Org org = orgDAO.loadById(id);
        orgDAO.delete(org);

    }

    @Override
    @Transactional
    public List<Org> all(){
        return orgDAO.all();
    }
}
