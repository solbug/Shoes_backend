package com.shoes.controller;

import com.shoes.repositoty.UserRepository;
import com.shoes.utils.DataTableResults;
import com.shoes.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

}
