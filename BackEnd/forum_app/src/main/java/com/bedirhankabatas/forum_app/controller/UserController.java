package com.bedirhankabatas.forum_app.controller;

import com.bedirhankabatas.forum_app.entities.Users;
import com.bedirhankabatas.forum_app.repository.UserRepository;
import com.bedirhankabatas.forum_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    public Users getOneUserById(@PathVariable("userId") Long userId){
        return userService.getOneUserById(userId);
    }
    @PostMapping("/create")
    public Users createUser(@RequestBody Users users){
        return userService.createUser(users);
    }
    @PutMapping("/update/{userId}")
    public Users updateUser(@PathVariable("userId") Long id,@RequestBody Users newUser){
        return userService.updateUser(id,newUser);
    }
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long id){
        userService.deleteUser(id);
    }

}
