package com.shoes.controller;

import com.shoes.repositoty.UserRepository;
import com.shoes.service.IUserService;
import com.shoes.utils.DataTableResults;
import com.shoes.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<?> createUser(@RequestBody UsersVO usersVO){
        UsersVO usersVO1 = userService.save(usersVO);
        if(usersVO1 == null){
            log.warn("Fail to create user");
            return new ResponseEntity<>(new ModelMap("exists_mail_message", "Email đã có người đăng ký"), HttpStatus.OK);
        }
        log.info("OK created the user!");
        return ResponseEntity.status(HttpStatus.CREATED).body(usersVO1);
    }
}
