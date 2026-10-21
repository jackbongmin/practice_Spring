package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// 예제 1.3 필드 주입: 간단하지만 final 불가, 테스트에서 가짜 객체를 넣을 통로가 없다.
@RestController
public class FieldInjectionController {

    @Autowired
    private MyService myService;

    // 매핑(@GetMapping)이 없으므로 URL 로는 접근할 수 없다. 주입 문법만 보여 주는 예제.
    public MyService getMyService() {
        return myService;
    }

}
