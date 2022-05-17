package com.cg.obb.controllers;

import java.util.*;
import com.cg.obb.entity.User;
import com.cg.obb.exceptions.UserNotFoundException;
import com.cg.obb.service.IUserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    IUserService userService;
    @CrossOrigin
    @GetMapping("{email}")
    public ResponseEntity<?> getUser(@PathVariable("email") String email, HttpServletRequest request){

        User user = userService.getUserByEmail(email);
        if(user == null){
            throw new UserNotFoundException("User with email: "+email+"not found");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(HttpServletRequest request){
        List<User> users = userService.getAllUsers();
        if(users.size()==0){
            throw new UserNotFoundException("No User found");
        }
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user,HttpServletRequest request){
        User saveUser = userService.addUser(user);
        //LOGGER.log(Level.INFO, "Save user called on controller");
        if(saveUser!=null){
            return new ResponseEntity<User>(saveUser,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<User>(saveUser,HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping("{email}")
    public ResponseEntity<User> deleteUser(@PathVariable("email") String email,HttpServletRequest request){
        User user = userService.removeUser(email);
        if(user!=null){
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @PutMapping("{email}")
    public ResponseEntity<User> updateUser(@PathVariable("email")String email,@RequestBody User user, HttpServletRequest request){

        User userExisting = userService.getUserByEmail(user.getEmail());
        if(userExisting==null){
            return new ResponseEntity<User>(userExisting,HttpStatus.NOT_FOUND);
        }
        userExisting.setAge(user.getAge());
        userExisting.setEmail(user.getEmail());
        userExisting.setName(user.getName());
        userExisting.setPh_no(user.getPh_no());

        User userUpdated = userService.updateUser(userExisting);
        if(userUpdated!=null){
            return new ResponseEntity<User>(userUpdated,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<User>(userUpdated,HttpStatus.NOT_FOUND);
        }

    }


}
