package com.linelect.service;

import com.linelect.model.User;
import java.util.List;

public interface UserService {
    boolean save();

    boolean remove();

    User getById(int id);

    User getByEmail();

    List<User> getAll();
}
