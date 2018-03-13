package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.Office;

import java.util.List;

public interface OfficeDAO {
   // List<Office> list(Long orgid,String name,String phone, boolean isActive);
    Office loadById(long id);
    void save(Office office);
    void update(Office office);
    void delete(Office office);
}
