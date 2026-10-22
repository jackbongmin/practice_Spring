package org.example.practice_spring.day02_hello.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제 4.1
 * - 가장 작은 컨트롤러
 * - @RestController : 이 클래스는 HTTP 요청을 받고, 반환값을 '응답 본문 그대로' 내보낸다.
 * - @RequestMapping("/day02/hello") : 이 경로의 요청은 hello()가 받는다.(method를 안적었으므로 GET/POST 등 전부 받음)
 * - 강의의 "/hello"에 /day2 접두어를 붙힌것
 */

@RestController
@CrossOrigin(origins = "http://localhost:5173")     // React(5173)의 호출을 허융
public class HelloController {
    @RequestMapping("/day02/hello")
    public String hello() {
        return "Hello World";       // 이 리터럴을 바꾸는 분기도, 외부 입력도 없다. -> 실행 안해도 응답 본문이 확정된다.
    }
}