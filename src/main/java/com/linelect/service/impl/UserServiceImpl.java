package com.linelect.service.impl;

import com.linelect.model.User;
import com.linelect.dao.UserDAO;
import com.linelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public void remove(int id) {
        userDAO.delete(id);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
