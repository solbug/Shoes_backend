package com.shoes.vo;

import java.io.Serializable;

import com.shoes.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Boolean active;

	private String email;

	private String name;

	private String password;

	private String photo;

	private String username;
	private String token;

	private Role role;

}