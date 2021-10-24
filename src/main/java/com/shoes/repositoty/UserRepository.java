package com.shoes.repositoty;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoes.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM  User u")
	Page<User> findUsers(Pageable pageable);

	@Query(value = "SELECT * FROM users WHERE users.name like %?1% and users.id like %?2%",
			nativeQuery = true)
	List<User> search(String name, Integer id);
	Optional<User> findByEmailContaining(String email);
	Optional<User> findByEmailContainingAndVerifyStatus(String email, Integer verifyStatus);
	Optional<User> findByName(Integer id);
	int countAllBy();
	User findByUsername(String username);
}