package com.example.euserservice.service;

import com.example.euserservice.dto.UserDto;
import com.example.euserservice.jpa.UserEntity;

public interface UserService {
    UserDto crateUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUsersByAll(); //가공하지 않고 그대로 사용하기 때문에 UserEntity 작성
}
