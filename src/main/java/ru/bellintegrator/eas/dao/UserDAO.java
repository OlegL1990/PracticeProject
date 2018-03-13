package ru.bellintegrator.eas.dao;

import ru.bellintegrator.eas.model.User;

import java.util.List;

public interface UserDAO {
    //List<User> list(long officeid,String firstName,String middleName,String lastName,String position,int docCode,int citizenshipCode);
    User loadById(long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}
