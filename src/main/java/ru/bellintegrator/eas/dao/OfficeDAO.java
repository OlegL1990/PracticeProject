package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.Office;
import  ru.bellintegrator.eas.model.Org;

import java.util.List;

public interface OfficeDAO {
    List<Office> loadByFilter(Long org,String name,String phone, Boolean isActive);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return Экземпляр Office с заданным id
     */
    Office loadById(long id);

    /**
     * Сохранить в бд переданный экземпляр Office
     *
     * @param office
     */
    void save(Office office);

    /**
     * Обновнить в бд переданный экземпляр Office
     *
     * @param office
     */
    void update(Office office);

    /**
     * Удалить из бд переданный экземпляр Office
     *
     * @param office
     */
    void delete(Office office);

    /**
     * Получить Org по идентификатору
     *
     * @param id
     * @return Экземпляр Org с заданным id
     */

    Org loadOrgById(Long id);


}
