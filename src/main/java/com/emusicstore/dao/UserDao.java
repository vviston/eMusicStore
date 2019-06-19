package com.emusicstore.dao;

import com.emusicstore.model.User;
import java.util.List;

public interface UserDao {

    void addUser(User product);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
