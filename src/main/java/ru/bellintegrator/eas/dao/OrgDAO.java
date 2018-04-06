package ru.bellintegrator.eas.dao;


import ru.bellintegrator.eas.model.Org;
import java.util.List;

public interface OrgDAO {

    /**
     * Получить List<Org> по фильтрку(name,inn,active)
     *
     * @param name,inn,isActive
     * @return Список List<Org>
     */
    List<Org> loadByFilter(String name,String inn,Boolean isActive);

    /**
     * Получить Org по идентификатору
     *
     * @param id
     * @return Экземпляр Org с заданным id
     */
    Org loadById(long id);

    /**
     * Обновнить в бд переданный экземпляр Org
     *
     * @param org
     */
    void update(Org org);

    /**
     * Сохранить в бд переданный экземпляр Org
     *
     * @param org
     */
    void save(Org org);

    /**
     * Удалить из бд переданный экземпляр Org
     *
     * @param org
     */
    void delete(Org org);

}
