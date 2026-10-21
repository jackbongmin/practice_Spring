package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제 1.3 - 필드 주입 문법을 보여주는 컨트롤러(URL 없음)
 * - 필드에 @Autowired 를 직접 붙여 주입받는다. 코드는 짧지만 final 불가, 테스트에서 가짜 객체를 넣을 통로가 없다.
 * - @GetMapping이 없어 요청을 받지 못한다. 주입 방식 비교용 예제
 */

@RestController
public class FieldInjectionController {
    @Autowired
    private MyService myService;

    // 매핑(@GetMapping)이 없으므로 URL로는 접근할 수 없다. 주입 문법만 보여주는 예제
    public MyService getMyService() {
        return myService;
    }
}