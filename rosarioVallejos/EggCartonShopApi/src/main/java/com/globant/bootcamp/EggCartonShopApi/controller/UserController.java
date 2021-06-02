package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.dao.UserRepository;
import com.globant.bootcamp.EggCartonShopApi.model.User;
import com.globant.bootcamp.EggCartonShopApi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auser")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping
    public void insUser(@RequestBody User user) {
        if (userRepository.findUserByNickName(user.getNickName()).isEmpty()) {
            userRepository.save(user);
        }
    }

    @GetMapping(value="/{nickName}")
    public Optional<User> getUserByNickName(@RequestBody User user){
            return userRepository.findUserByNickName(user.getNickName());
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
