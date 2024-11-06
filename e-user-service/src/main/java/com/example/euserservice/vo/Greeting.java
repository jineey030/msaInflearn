package com.example.euserservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor Args를 모두 가지고 있는 생성자 추가
//@NoArgsConstructor default 생성자 추가
public class Greeting {

    @Value("${greeting.message}")
    private String message;
}
