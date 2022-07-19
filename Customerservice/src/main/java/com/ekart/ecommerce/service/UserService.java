package com.ekart.ecommerce.service;

import com.ekart.ecommerce.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Integer id);
    User getUserByName(String userName);

    User saveUser(User user);

}
