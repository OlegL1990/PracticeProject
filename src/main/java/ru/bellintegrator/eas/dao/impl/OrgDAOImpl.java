package ru.bellintegrator.eas.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.eas.dao.OrgDAO;
import ru.bellintegrator.eas.model.Org;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        Org orgTemp = em.find(Org.class, org.getId());
        orgTemp.setName(org.getName());
        orgTemp.setFullName(org.getFullName());
        orgTemp.setInn(org.getInn());
        orgTemp.setKpp(org.getKpp());
        orgTemp.setAddress(org.getAddress());
        orgTemp.setPhone(org.getPhone());
        orgTemp.setActive(org.getActive());
        em.merge(orgTemp);
    }

    @Override
    public void delete(Org org) {
        em.remove(org);
    }

    @Override
    public List<Org> loadByFilter(String name, String inn, Boolean isActive) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Org.class);
        Root<Org> orgRoot = cq.from(Org.class);

        Predicate predicate = cb.conjunction();

        //name
        Predicate pa = cb.equal(orgRoot.get("name"), name);
        predicate = cb.and(predicate, pa);

        //inn
        if (inn != null) {
            Predicate p = cb.equal(orgRoot.get("inn"), inn);
            predicate = cb.and(predicate, p);
        }
        //active
        if (isActive != null) {
            Predicate p = cb.equal(orgRoot.get("isActive"), isActive);
            predicate = cb.and(predicate, p);
        }

        cq.where(predicate);
        TypedQuery<Org> query = em.createQuery(cq);
        List<Org> result = query.getResultList();
        return result;

    }
}
