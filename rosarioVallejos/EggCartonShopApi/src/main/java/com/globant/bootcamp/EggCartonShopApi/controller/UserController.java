package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.repository.UserRepository;
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
    public String insUser(@RequestBody User user) {
        if (userRepository.findUserByNickName(user.getNickName()).isEmpty()) {
            userRepository.save(user);
            return "creado";
        } else return "no creado";
    }

    @GetMapping(value="/{nickName}")
    public Optional<User> getUserByNickName(User user){
            return userRepository.findUserByNickName(user.getNickName());
        }


    @PutMapping
    public String updUser(@RequestBody User user){
        userRepository.save(user);
        return "usuario actualizado";
    }

    @DeleteMapping(value="/{id}")
    public String deleteProd(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "usuario eliminado";
    }

}
