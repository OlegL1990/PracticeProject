package ru.bellintegrator.eas.service;

import ru.bellintegrator.eas.model.Org;
import ru.bellintegrator.eas.view.OrgView;

import java.util.List;

public interface OrgService {

    /**
     * Получить OrgView по идентификатору
     *
     * @param id
     * @return Экземпляр OrgView с заданным id
     */
    OrgView loadById(long id);

    /**
     * Сохранить  OrgView
     *
     * @param orv
     */
    void save(OrgView orv);

    /**
     * Обновнить  OrgView
     *
     * @param orv
     */
    void update(OrgView orv);

    /**
     * Удалить Org по идентификатору
     *
     * @param id
     */
    void delete(long id);


}
