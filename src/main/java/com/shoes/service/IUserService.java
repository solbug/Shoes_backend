package com.shoes.service;


import java.util.List;
import java.util.Optional;

import com.shoes.entity.User;
import com.shoes.vo.UsersVO;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    User findByUsername(String username);

    UsersVO save(UsersVO usersVO);

    List<UsersVO> findAll(Pageable pageable);

    List<UsersVO> findAll();

    UsersVO findOneById(Integer id);

    Optional<User> findById(Integer id);

    void deleteUserById(Integer id, Integer status);

    List<UsersVO> search(String name, Integer id);

    UsersVO update(Integer id, UsersVO usersVO);

}