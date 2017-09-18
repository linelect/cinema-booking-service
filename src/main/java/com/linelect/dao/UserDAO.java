package com.linelect.dao;

import com.linelect.model.User;

import java.util.List;

public interface UserDAO {
    User save(User user);

    User add(User user);

    void delete(int id);

    User getById(int id);

    User getByEmail(String email);

    List<User> getAll();
}
