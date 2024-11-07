package com.example.euserservice.service;

import com.example.euserservice.dto.UserDto;
import com.example.euserservice.jpa.UserEntity;
import com.example.euserservice.jpa.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto crateUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        
        //클래스 변환
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); //환경 설정 정보(딱 맞아 떨어질 경우에만 실행하도록 전략)
        UserEntity userEntity = mapper.map(userDto, UserEntity.class); //변환 시작
        userEntity.setEncryptPwd("encrypted_password"); //구현 전이므로 default값 저장
        
        userRepository.save(userEntity);

        UserDto returnUserDto = mapper.map(userEntity, UserDto.class);

        return returnUserDto;
    }
}
