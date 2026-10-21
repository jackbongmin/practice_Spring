package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제 1.4 - setter 주입 문법을 보여 주는 컨트롤러 (URL 없음).
 * - @Autowired 가 붙은 setter 메서드로 주입받는다. 선택적 의존성에 쓰지만 final 불가,
 *   setter 호출 전에는 객체가 불완전한 상태로 존재할 수 있다.
 * - @GetMapping 이 없어 요청을 받지 못한다. 주입 방식 비교용 예제.
 */

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