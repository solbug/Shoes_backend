package com.shoes.controller;

import com.shoes.entity.User;
import com.shoes.repositoty.UserRepository;
import com.shoes.service.IUserService;
import com.shoes.utils.DataTableResults;
import com.shoes.vo.DeleteVO.Delete;
import com.shoes.vo.DeleteVO.DeleteResponse;
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

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> createUser(@RequestBody UsersVO usersVO) {
        UsersVO usersVO1 = userService.save(usersVO);
        if (usersVO1 == null) {
            log.warn("Fail to create user");
            return new ResponseEntity<>(new ModelMap("exists_mail_message", "Email đã có người đăng ký"), HttpStatus.OK);
        }
        log.info("OK created the user!");
        return ResponseEntity.status(HttpStatus.CREATED).body(usersVO1);
    }

    @PutMapping("/update")
    public ResponseEntity<UsersVO> update(@RequestBody UsersVO usersVO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(usersVO));
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<?> deleteUser(@RequestBody Delete deleteUser) {
        Optional<User> user = userService.findById((deleteUser.getId()));
        DeleteResponse deleteResponse = new DeleteResponse();
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (deleteUser.getStatus()) {
            if (user.get().getStatus()) {
                deleteResponse.setStatus(200);
                deleteResponse.setMessage("Tài khoản đang mở");
                log.warn("Tài khoản đang mở.");
            }else {
                userService.deleteUserById(deleteUser.getId(), deleteUser.getStatus());
                deleteResponse.setStatus(200);
                deleteResponse.setMessage("Mở khóa tài khoản");
                log.warn("Mở khóa tài khoản");
            }
        } else {
            if (!user.get().getStatus()) {
                deleteResponse.setStatus(201);
                deleteResponse.setMessage("Tài khoản đã được xóa trước đó");
                log.warn("Tài khoản đã xóa trước đó.");
            }else {
                userService.deleteUserById(deleteUser.getId(), deleteUser.getStatus());
                deleteResponse.setStatus(200);
                deleteResponse.setMessage("Xóa tài khoản thành công");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(deleteResponse);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/searchNameUser")
    public ResponseEntity<?> searchNameUser(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "id", required = false) Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.search(name, id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersVO>> findAllUser(){
        List<UsersVO> usersVOList = userService.findAll();
        if(usersVOList== null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        log.info("Get All blogger");
        return ResponseEntity.status(HttpStatus.OK).body(usersVOList);
    }

    //Tim theo id
    @GetMapping("/{id}")
    public ResponseEntity<UsersVO> findOneById(@PathVariable("id") Integer id) {
        UsersVO usersVO = userService.findOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usersVO);
    }
}
