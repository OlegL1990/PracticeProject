package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.OfficeDAO;
import ru.bellintegrator.eas.model.Office;
import ru.bellintegrator.eas.model.Org;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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


    @Override
    public List<Office> loadByFilter(Long org, String name, String phone, Boolean isActive) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Office.class);
        Root<Office> officeRoot = cq.from(Office.class);

        Predicate predicate = cb.conjunction();

        //org
        Predicate pa = cb.equal(officeRoot.join("org").get("id"), org);
        predicate = cb.and(predicate, pa);

        //name
        if (name != null) {
            Predicate p = cb.equal(officeRoot.get("name"), name);
            predicate = cb.and(predicate, p);
        }
        //phone
        if (phone != null) {
            Predicate p = cb.equal(officeRoot.get("phone"), phone);
            predicate = cb.and(predicate, p);
        }
        //isActive
        if (isActive!= null) {
            Predicate p = cb.equal(officeRoot.get("isActive"), isActive);
            predicate = cb.and(predicate, p);
        }

        cq.where(predicate);
        List<Office> result = em.createQuery(cq).getResultList();
        return result;

    }
}

