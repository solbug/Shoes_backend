package com.shoes.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoes.service.IUserService;


@RestController
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @PreAuthorize(("isAuthenticated()"))
    @GetMapping("/user/info")
    public Authentication readAll(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}