package ru.bellintegrator.eas.dao;


import ru.bellintegrator.eas.model.Org;
import java.util.List;

public interface OrgDAO {
   // List<Org> list(String name,String inn,boolean isActive);
    Org loadById(long id);
    void update(Org org);
    void save(Org org);
    void delete(Org org);
}
