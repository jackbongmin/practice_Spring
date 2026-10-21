package org.example.practice_spring.day01_di.service;

import org.springframework.stereotype.Service;

/** 이행(구현체): @Service가 붙어있어야 스프링 컨테이너가 Bean으로 관리함 */
@Service
public class MyServiceImpl implements MyService {

    @Override
    public String getHello() {
        return "Hello";
    }
}