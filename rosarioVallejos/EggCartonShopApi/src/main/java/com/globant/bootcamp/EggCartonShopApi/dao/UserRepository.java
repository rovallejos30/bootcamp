package com.globant.bootcamp.EggCartonShopApi.dao;

import com.globant.bootcamp.EggCartonShopApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
