package com.nexpay.traineetask.service;

import com.nexpay.traineetask.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User updateById(Integer id, User user);

    User getById(int id);

    void deleteById(int id);

    List<User> getAll();

}
