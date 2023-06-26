package com.zawisza.restapitwo.controller;

import com.zawisza.restapitwo.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor - automatyczny konstruktor
public class HelloController {


    private final HelloService helloService;

    //@Autowired - na konstruktorze już nie trzeba używać (do wskrzykiwania zależności)
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    //Mapowanie = określanie ścieżki
    public String hello(){
        return helloService.hello();
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hi";
    }
}
