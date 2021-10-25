package com.shoes.mapper.imp;

import com.shoes.config.ModelMapperConfig;
import com.shoes.entity.Role;
import com.shoes.entity.User;
import com.shoes.mapper.UserMapper;
import com.shoes.vo.UsersVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImp implements UserMapper {
    ModelMapper modelMapper;
    @Autowired
    private ModelMapperConfig modelMapperConfig;

    @Override
    public User toEntity(UsersVO vo) {
        modelMapper = new ModelMapper();
        User user = modelMapper.map(vo, User.class);
        return user;
    }

    @Override
    public UsersVO toDto(User entity) {
        modelMapper = new ModelMapper();
        UsersVO usersVO = modelMapper.map(entity, UsersVO.class);
        Role role = usersVO.getRole();
        role.setUsers(null);
        usersVO.setRole(role);
        return usersVO;
    }

    @Override
    public List<User> toEntity(List<UsersVO> voList) {
        List<User> userList = new ArrayList<>();
        voList.forEach((vo) -> {
                    userList.add(toEntity(vo));
                }
        );
        return userList;
    }

    @Override
    public List<UsersVO> toDto(List<User> entityList) {
        List<UsersVO> usersVOList = new ArrayList<>();
        entityList.forEach((entity) ->{
            usersVOList.add(toDto(entity));
        });
        return usersVOList;
    }
}
