package ru.bellintegrator.eas.service;

import ru.bellintegrator.eas.view.OfficeView;

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
}
