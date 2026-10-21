package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 예제 1.2 생성자를 통한 의존성 주입 (권장 방식)
@RestController
public class DIController {

    private final MyService myService;

    // 생성자가 하나뿐이면 @Autowired 생략 가능. 구현체(MyServiceImpl)의 이름이 이 파일에 없다.
    public DIController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/day01/di/hello")
    public String getHello() {
        return myService.getHello();
    }

}
