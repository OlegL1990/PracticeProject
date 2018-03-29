package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.OfficeDAO;
import ru.bellintegrator.eas.model.Office;
import ru.bellintegrator.eas.model.Org;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {
    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Office loadById(long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public void update(Office office) {
        em.merge(office);
    }

    public void delete(Office office) {
        em.remove(office);
    }

    @Override
    public Org loadOrgById(Long id) {
        return em.find(Org.class, id);
    }

    //@Override
    //public List<Office> list(Long orgid, String name, String phone, boolean isActive) {
    //сделать с помощью Criteria API
    //}
}

