package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getAll()
    {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId)
    {
        return userService.findById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public User update(@RequestBody User user)
    {
        userService.save(user);

        return user;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId)
    {
        userService.deleteById(userId);
    }
}
