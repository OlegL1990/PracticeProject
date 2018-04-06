package ru.bellintegrator.eas.service;

import ru.bellintegrator.eas.view.OfficeView;
import ru.bellintegrator.eas.model.Office;

import java.util.List;

public interface OfficeService {

    /**
     * Получить OfficeView по идентификатору
     *
     * @param id
     * @return Экземпляр OfficeView с заданным id
     */
    OfficeView loadById(long id);

    /**
     * Сохранить  OfficeView
     *
     * @param ov
     */
    void save(OfficeView ov);

    /**
     * Обновнить  OfficeView
     *
     * @param ov
     */
    void update(OfficeView ov);

    /**
     * Удалить Office по идентификатору
     *
     * @param id
     */
    void delete(long id);

    /**
     * Получить List<Office> по фильтру из ov
     *
     * @param ov
     * @return Список List<Office>
     */
    List<Office> filter(OfficeView ov);
}
