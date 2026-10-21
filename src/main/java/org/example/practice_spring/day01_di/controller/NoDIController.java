package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.example.practice_spring.day01_di.service.MyServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 예제 1.1 일반적인 자바 코드에서의 객체 사용법 (DI 없음)
@RestController
public class NoDIController {

    // 선언은 인터페이스, 생성은 구현체 -> 생성 책임과 사용 책임이 한 줄에 붙어 있다.
    private final MyService service = new MyServiceImpl();

    @GetMapping("/day01/no-di/hello")
    public String getHello() {
        return service.getHello();
    }

}
