package com.shoes.service.serviceImp;
import com.shoes.mapper.UserMapper;
import com.shoes.service.CustomerUserDetails;
import com.shoes.service.IUserService;
import com.shoes.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoes.entity.User;
import com.shoes.repositoty.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements IUserService, UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private UserRepository usersRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	PasswordEncoder passwordEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomerUserDetails(user);
	}

	@Override
	public User findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

	@Override
	public UsersVO update(UsersVO usersVO) {
		Optional<User> userOptional = usersRepository.findById(usersVO.getId());
		if (!userOptional.isPresent()) {
			return null;
		}
		User userOld = userOptional.get();
		String passwordHash = passwordEncoder.encode(usersVO.getPassword());
		usersVO.setPassword(passwordHash);
		userOld.setEmail(usersVO.getEmail());
		userOld.setUsername(usersVO.getUsername());
		userOld.setName(usersVO.getName());
		userOld.setRole(usersVO.getRole());
		userOld.setPassword(usersVO.getPassword());
		userOld.setPhoneNumber(usersVO.getPhoneNumber());
		userOld.setStatus(usersVO.getStatus());
		return userMapper.toDto(usersRepository.save(userOld));
	}

	@Override
	public UsersVO save(UsersVO usersVO) {
		if(isExistsEmail(usersVO.getEmail())){
			return null;
		}
		User user = userMapper.toEntity(usersVO);
		String passwordHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHash);
		user.setStatus(true);
		user.setVerifyStatus(0);
		user.setRole(usersVO.getRole());
		user.setVerifyCode(UUID.randomUUID());
		User userNew = usersRepository.save(user);
		return userMapper.toDto(userNew);
	}

	@Override
	public List<UsersVO> findAll(Pageable pageable) {
		Page<User> users = usersRepository.findUsers(pageable);
		List<User> userList = users.getContent();
		return userMapper.toDto(userList);
	}

	@Override
	public List<UsersVO> findAll() {
		List<User> userList = usersRepository.findAll();
		return userMapper.toDto(userList);
	}

	@Override
	public UsersVO findOneById(Integer id) {
		Optional<User> userOptional = usersRepository.findById(id);
		if (userOptional.isPresent()) {
			return userMapper.toDto(userOptional.get());
		} else {
			return null;
		}
	}


	@Override
	public Optional<User> findById(Integer id) {
		return usersRepository.findById(id);
	}

	@Override
	public void deleteUserById(Integer id, Boolean status) {
		Optional<User> userOptional = usersRepository.findById(id);
		User user = userOptional.get();
		user.setStatus(status);
		userMapper.toDto(usersRepository.save(user));
	}

	@Override
	public List<UsersVO> search(String name, Integer id) {
		List<User> userList = usersRepository.search(name, id);
		return userMapper.toDto(userList);
	}

	public boolean isExistsEmail(String email) {
		for (UsersVO usersVO : findAll()) {
			if (usersVO.getEmail().equalsIgnoreCase(email)) {
				log.warn("Email is existed");
				return true;
			}
		}
		return false;
	}
}