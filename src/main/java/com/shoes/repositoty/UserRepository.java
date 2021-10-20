package com.shoes.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoes.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findById(Integer id);
	Optional<User> findByEmailContaining(String email);
	Optional<User> findByEmailContainingAndVerifyStatus(String email, Integer verifyStatus);
	Optional<User> findByName(Integer id);
	int countAllBy();
	User findByUsername(String username);
}