package ru.bellintegrator.eas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.eas.dao.OfficeDAO;
import ru.bellintegrator.eas.model.Office;
import ru.bellintegrator.eas.service.OfficeService;
import ru.bellintegrator.eas.view.OfficeView;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDAO officeDAO;

    @Override
    @Transactional(readOnly = true)
    public OfficeView loadById(long id) {
        Office office = officeDAO.loadById(id);
        OfficeView ov = new OfficeView();
        ov.setId(office.getId());
        ov.setName(office.getName());
        ov.setAddress(office.getAddress());
        ov.setPhone(office.getPhone());
        ov.setActive(office.getActive());
        return ov;
    }

    @Override
    @Transactional
    public void save(OfficeView ov) {
        Office office = new Office();
        office.setName(ov.getName());
        office.setAddress(ov.getAddress());
        office.setPhone(ov.getPhone());
        office.setActive(ov.getActive());
        office.setOrg(officeDAO.loadOrgById(ov.getOrg()));
        officeDAO.save(office);

    }

    @Override
    @Transactional
    public void update(OfficeView ov) {
        Office office = new Office();
        office.setId(ov.getId());
        office.setName(ov.getName());
        office.setAddress(ov.getAddress());
        office.setPhone(ov.getPhone());
        office.setActive(ov.getActive());
        officeDAO.update(office);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Office office = officeDAO.loadById(id);
        officeDAO.delete(office);

    }
}
