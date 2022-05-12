package kruten.overmobile.controller;


import kruten.overmobile.entity.User;
import kruten.overmobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class Main {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> postUser(@Valid @RequestBody User user) {
        try{
            return new ResponseEntity<>(userService.postUser(user), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf(0));
        }
    }
}
