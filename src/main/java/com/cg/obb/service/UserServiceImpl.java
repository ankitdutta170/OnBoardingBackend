package com.cg.obb.service;


import com.cg.obb.dao.IUserRepository;
import com.cg.obb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User removeUser(String email) {
        Optional<User> userToBeDeleted = Optional.ofNullable(userRepository.findByEmail(email));

        if(userToBeDeleted.isPresent()){
            User user = userToBeDeleted.get();
            userRepository.delete(userToBeDeleted.get());
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.findByEmail(user.getEmail())!=null){
            //User userToBeUpdated = userRepository.findByEmail(user.getEmail());
            userRepository.save(user);
            return user;
        }
        return null;
    }


}
