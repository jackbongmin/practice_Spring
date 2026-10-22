package org.example.practice_spring.day02_hello.controller;

import java.util.List;
import org.example.practice_spring.day02_hello.dto.HelloResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * React(포트 5173)가 fetch로 호출하는 JSON API
 * - @CrossOrigin : "http://localhost:5173 에서 온 요청을 허용한다" (CORS). 이 줄이 없으면 브라우저가 응답을 막는다.
 * - GET /day02/hello/{id}/test?name=영희&age=30
 *       {id}            -> @PathVariable   (경로의 일부)
 *       name, age       -> @RequestParam   (? 뒤 질의 문자열)
 * - 반환 타입이 List 이므로 JSON '배열'이 된다. -> React의 jsonData[0]와 맞물린다.
 */

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class HelloApiController {

    @GetMapping("/day02/hello/{id}/test")
    public List<HelloResponse> test(@PathVariable("id") Long id,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") int age) {
        return List.of(new HelloResponse(id, name, age));
    }
}
