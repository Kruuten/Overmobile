package kruten.overmobile.controller;


import kruten.overmobile.entity.User;
import kruten.overmobile.response.ResponseHandler;
import kruten.overmobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity postUser(@Valid @RequestBody User user) {
        userService.postUser(user);
        return ResponseHandler.generateResponse(0);
    }

}
