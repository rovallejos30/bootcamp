package com.globant.bootcamp.EggCartonShopApi.dao;

import com.globant.bootcamp.EggCartonShopApi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
