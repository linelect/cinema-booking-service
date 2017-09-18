package com.linelect.repository;

import com.linelect.model.User;

import java.util.List;

public interface UserRepository  {


    User saveAndFlush(User user);

    void delete(int id);

    User getOne(int id);

    List<User> findAll();

}
