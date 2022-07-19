package com.ekart.ecommerce.controller;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.ekart.ecommerce.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;



    @GetMapping (value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<com.ekart.ecommerce.entity.User> users =  userService.getAllUsers();
        if(!users.isEmpty()) {
            return new ResponseEntity<>(
                    (MultiValueMap<String, String>) users,
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(
                HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/users", params = "name")
    public ResponseEntity<User> getUserByName(@RequestParam("name") String userName){
        User user = (User) userService.getUserByName(userName);
        if(user != null) {
            return new ResponseEntity<User>(
                    user,
                    HttpStatus.OK);
        }
        return new ResponseEntity<User>(
                HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = (User) userService.getUserById(Math.toIntExact(id));
        if(user != null) {
            return new ResponseEntity<User>(
                    user,
                    HttpStatus.OK);
        }
        return new ResponseEntity<User>(
                HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request){
        if(user != null)
            try {
                userService.saveUser((com.ekart.ecommerce.entity.User) user);
                return new ResponseEntity<User>(
                        user,
                        HttpStatus.CREATED);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

}
