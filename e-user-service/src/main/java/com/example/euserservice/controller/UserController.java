package com.example.euserservice.controller;

import com.example.euserservice.dto.UserDto;
import com.example.euserservice.jpa.UserEntity;
import com.example.euserservice.service.UserService;
import com.example.euserservice.vo.Greeting;
import com.example.euserservice.vo.RequestUser;
import com.example.euserservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private Environment env;
    private UserService userService;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @Autowired
    private Greeting greeting;

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service"
                    + ", port(local.server.port)= "+env.getProperty("local.server.port")
                    + ", port(server.port)= "+env.getProperty("server.port")
                    + ", token secret = "+env.getProperty("token.secret")
                    + ", token expiration = "+env.getProperty("token.expiration_time"));
    }

    @GetMapping("/welcome")
    public String welcome(){
//        return env.getProperty("greeting.message");
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){//RequestUser 타입은 RequestBody 형태로 전달됨
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseUser.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId){
        UserDto userDto = userService.getUserByUserId(userId);

        ResponseUser returnValue = new ModelMapper().map(userDto, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }



}
