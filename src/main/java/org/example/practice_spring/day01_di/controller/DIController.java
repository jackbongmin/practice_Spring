package org.example.practice_spring.day01_di.controller;

import org.example.practice_spring.day01_di.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제 1.2 - 생성자 주입(DI)을 쓰는 컨트롤러 (권장 방식).
 * - GET /day01/di/hello 요청을 받아 서비스의 결과를 응답한다.
 * - MyService 를 생성자 파라미터로 선언만 하면 스프링이 Bean 을 넣어 준다.
 *   구현체(MyServiceImpl)의 이름이 이 파일에 한 번도 나오지 않는다.
 */

@RestController
public  class DIController {

    private final MyService myService;

    // 생성자가 하나뿐이면 @Autowired 생략 가능. 구현체(MyServiceImpl)의 이름이 이 파일에 없음.
    public DIController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/day01/di/hello")
    public String getHello() {
        return myService.getHello();
    }
}