package com.shoes.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoes.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}