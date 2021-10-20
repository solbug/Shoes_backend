package com.shoes.service;


import com.shoes.entity.User;
import com.shoes.vo.UsersVO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User findByUsername(String username);

    UsersVO save(UsersVO usersVO);

    UsersVO update(Integer id, UsersVO usersVO);

    List<UsersVO> findAll();

    UsersVO findOneById(Integer id);

    Optional<User> findById(Integer id);

    void deleteUserById(Integer id, Integer status);

}
