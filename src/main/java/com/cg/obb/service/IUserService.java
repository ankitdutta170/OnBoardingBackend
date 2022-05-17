package com.cg.obb.service;

import com.cg.obb.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;


public interface IUserService {

    public User getUserByEmail(String email);
    public List<User> getAllUsers();
    public User addUser(User user);
    public User removeUser(String email);
    public User updateUser(User user);

}
