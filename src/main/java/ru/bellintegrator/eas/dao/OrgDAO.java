package ru.bellintegrator.eas.dao;


import ru.bellintegrator.eas.model.Org;
import java.util.List;

public interface OrgDAO {
   // List<Org> list(String name,String inn,boolean isActive);

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

    List<Org> all();
}
