package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.OrgDAO;
import ru.bellintegrator.eas.model.Org;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrgDAOImpl implements OrgDAO {
    private final EntityManager em;

    @Autowired
    public OrgDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Org loadById(long id) {
        return em.find(Org.class, id);
    }

    @Override
    public void save(Org org) {
        em.persist(org);
    }

    @Override
    public void update(Org org) {
        em.merge(org);
    }

    @Override
    public void delete(Org org) {
        em.remove(org);
    }



    //@Override
    //List<Org> list(String name,String inn,boolean isActive) {
    //сделать с помощью Criteria API
    //}
}
