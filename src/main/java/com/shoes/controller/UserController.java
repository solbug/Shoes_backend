package com.shoes.controller;

import com.shoes.entity.User;
import com.shoes.repositoty.UserRepository;
import com.shoes.service.IUserService;
import com.shoes.utils.DataTableResults;
import com.shoes.vo.MessageVO;
import com.shoes.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

        @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody UsersVO usersVO){
        UsersVO usersVO1 = userService.save(usersVO);
        if(usersVO1 == null){
            log.warn("Fail to create user");
            return new ResponseEntity<>(new ModelMap("exists_mail_message", "Email đã có người đăng ký"), HttpStatus.OK);
        }
        log.info("OK created the user!");
        return ResponseEntity.status(HttpStatus.CREATED).body(usersVO1);
    }

    @PutMapping("/update")
    public ResponseEntity<UsersVO> update(@RequestBody UsersVO usersVO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usersVO));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id, Integer status) {
        userService.deleteUserById(id, status);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageVO("Xóa thành công"));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

}
