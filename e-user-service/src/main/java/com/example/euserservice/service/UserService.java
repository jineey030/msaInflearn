package com.example.euserservice.service;

import com.example.euserservice.dto.UserDto;
import com.example.euserservice.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto crateUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUsersByAll();
}
