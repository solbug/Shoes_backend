package com.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoes.config.TokenProvider;
import com.shoes.entity.User;
import com.shoes.service.serviceImp.UserServiceImp;
import com.shoes.vo.LoginVo;
import com.shoes.vo.UsersVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@RestController
public class AuthenticationController {

	@Autowired
	private UserServiceImp userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenProvider jwtTokenUtil;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity login(@RequestBody LoginVo vo) throws AuthenticationException {

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(vo.getUsername(), vo.getPassword()));
		// Lấy token của người dùng
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);

		// Gán lại giá trị cho UserVo để hiển thị lên thông tin
		UsersVO usersVO = new UsersVO();
		usersVO.setToken(token);
		usersVO.setUsername(vo.getUsername());
		// Từ Username lấy thông tin của member
		User users = userService.findByUsername(vo.getUsername());
		usersVO.setId(users.getId());
		usersVO.setName(users.getUsername());
		usersVO.setEmail(users.getEmail());

		return ResponseEntity.ok(usersVO);
	}

}
