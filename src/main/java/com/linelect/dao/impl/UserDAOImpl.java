package com.linelect.dao.impl;

import com.linelect.dao.InMemoryDataBaseSimulator;
import com.linelect.dao.UserDAO;
import com.linelect.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private int id = 1;

    @Override
    public User save(User user) {
        if (user.isNew()) {
            add(user);
        } else {
            delete(user.getId());
            add(user);
        }
        return user;
    }

    @Override
    public User add(User user) {
        user.setId(id++);
        InMemoryDataBaseSimulator.getUsers().add(user);
        return user;
    }

    @Override
    public void delete(int id) {
        InMemoryDataBaseSimulator.getUsers().remove(getById(id));
    }

    @Override
    public User getById(int id) {
        return InMemoryDataBaseSimulator.getUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst().orElse(new User());
    }

    @Override
    public User getByEmail(String email) {
        return InMemoryDataBaseSimulator.getUsers().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst().orElse(new User());
    }

    @Override
    public List<User> getAll() {
        return InMemoryDataBaseSimulator.getUsers();
    }
}
