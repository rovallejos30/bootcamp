package com.globant.bootcamp.EggCartonShopApi.repository;

import com.globant.bootcamp.EggCartonShopApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickName(String nickName);

}
