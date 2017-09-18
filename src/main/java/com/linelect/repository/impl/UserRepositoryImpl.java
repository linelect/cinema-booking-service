package com.linelect.repository.impl;

import com.linelect.model.User;
import com.linelect.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User saveAndFlush(User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User getOne(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("User1");
        users.add(user1);
        return users;
    }
}
