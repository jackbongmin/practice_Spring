package org.example.practice_spring.day01_di.service;

import org.springframework.stereotype.Service;

/** 이행(구현체): @Service 가 붙어 있어야 스프링 컨테이너가 Bean 으로 관리한다. */
@Service
public class MyServiceImpl implements MyService {

    @Override
    public String getHello() {
        return "Hello";
    }

}
