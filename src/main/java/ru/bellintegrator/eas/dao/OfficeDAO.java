package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.Office;

import java.util.List;

public interface OfficeDAO {
   // List<Office> list(Long orgid,String name,String phone, boolean isActive);

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
}
