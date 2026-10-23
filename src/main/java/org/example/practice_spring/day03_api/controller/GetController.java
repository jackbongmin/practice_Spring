package org.example.practice_spring.day03_api.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.example.practice_spring.day03_api.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * GET 요청에서 값을 받는 3가지 방식(path / query 개별 / query DTO)을 비교하는 연습용 컨트롤러
 * - 클래스에 붙인 @RequestMapping은 모든 메서드 경로의 공통 앞부분이 된다.
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // GET /api/v1/get-api/hello -> Hello World
    @GetMapping("/hello")
    public String hello() {
        log.info("hello 호출");
        return "Hello World!";
    }

    // GET /api/v1/get-api/variable/test -> test    (path 값)
    @GetMapping("/variable/{variable}")
    public String variable(@PathVariable String variable) {
        log.info("path 로 들어온 값 : {}", variable);
        return variable;
    }

    // GET /api/v1/get-api/request1?name=kim&email=k@x.com&organization=kyobo
    // 개별 @RequestParam 은 기본이 필수 -> 하나라도 빠지면 400
    @GetMapping("/request1")
    public String request1(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // GET /api/v1/get-api/request2?a=1&b=2
    // Map 은 key 제한이 없다 -> 무슨 key 가 와도 통과
    @GetMapping("/request2")
    public String request2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.forEach((k, v) -> sb.append(k).append(" : ").append(v).append("\n"));
        return sb.toString();
    }

    // GET /api/v1/get-api/request3?name=kim&email=k@x.com   (organization 생략)
    // DTO 는 필드명이 계약 -> 빠진 값은 400 이 아니라 null
    @GetMapping("/request3")
    public String request3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
