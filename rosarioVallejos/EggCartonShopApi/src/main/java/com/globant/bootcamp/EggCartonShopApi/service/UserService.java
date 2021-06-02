package com.globant.bootcamp.EggCartonShopApi.service;

import com.globant.bootcamp.EggCartonShopApi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listUsers();
    Optional<User> findByName(String nickName);

}
