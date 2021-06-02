package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.dao.UserRepository;
import com.globant.bootcamp.EggCartonShopApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auser")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping
    public void insUser(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping
    public void updUser(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping(value="/{id}")
    public void deleteProd(@PathVariable("id") Long id){
        userRepository.deleteById(id);

    }
}
