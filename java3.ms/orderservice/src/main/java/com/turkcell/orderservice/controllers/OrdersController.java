package com.turkcell.orderservice.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final WebClient.Builder webClientBuilder;


    @PostMapping
    public String addOrder(){

        //should go to the product service and get stock information of the products

        var result= webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8086/api/v1/products?productId=2")
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        

        return "Order added.";
    }
}
