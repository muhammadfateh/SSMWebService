package com.webapp.template.controllers;

import com.webapp.template.model.User;
import com.webapp.template.service.UserService;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/")
public class UserController {
    private final UserService userService = new UserService();

    @PostMapping(value = "signup")
    public HttpEntity<?> createUser(@RequestBody User user){
        try {
            userService.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody String body){
        try {
            JSONObject object = new JSONObject(body);
            userService.signIn(object.getString("username"), object.getString("password"));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
