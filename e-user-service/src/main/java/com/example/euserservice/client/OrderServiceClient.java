package com.example.euserservice.client;

import com.example.euserservice.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="order-service")
public interface OrderServiceClient {

    //interface는 모두 public으로 사용해야 하기 때문에 굳이 public을 명시하지 않아도 됨
    @GetMapping("/order-service/{userId}/orders")
    List<ResponseOrder> getOrders(@PathVariable String userId);

}
