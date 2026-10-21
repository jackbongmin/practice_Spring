package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// 예제 1.4 setter 주입: 선택적 의존성에 쓰지만 final 불가, 객체가 불완전한 상태로 존재할 수 있다.
@RestController
public class SetterInjectionController {

    private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    public MyService getMyService() {
        return myService;
    }

}
