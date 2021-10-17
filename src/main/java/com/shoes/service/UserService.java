package com.shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoes.entity.User;
import com.shoes.repositoty.UserRepository;

@Service
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository usersRepository;

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomerUserDetails(user);
	}

	@Override
	public User findUser(String user) {
		return usersRepository.findByUsername(user);

	}

}
