package com.linelect.service.impl;

import com.linelect.model.User;
import com.linelect.repository.UserRepository;
import com.linelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void remove(int id) {
        userRepository.delete(id);
    }

    @Override
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
