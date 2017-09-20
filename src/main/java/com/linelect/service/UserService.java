package com.linelect.service;

import com.linelect.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    User add(User user);

    void remove(int id);

    User getById(int id);

    User getByEmail(String email);

    List<User> getAll();
}
