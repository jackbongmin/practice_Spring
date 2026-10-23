package org.example.practice_spring.day03_api.controller;

import java.util.Map;
import org.example.practice_spring.day03_api.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * POST 는 값을 URL 이 아니라 요청 body(JSON)에 담아 보낸다.
 * - 요청에 Content-Type: application/json 헤더가 있어야 @RequestBody 가 JSON 으로 읽는다.
 */
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    // POST /api/v1/post-api/member  (Map: 어떤 key 든 받는다)
    @PostMapping("/member")
    public String member(@RequestBody Map<String, Object> body) {
        StringBuilder sb = new StringBuilder();
        body.forEach((k, v) -> sb.append(k).append(" : ").append(v).append("\n"));
        return sb.toString();
    }

    // POST /api/v1/post-api/member2  (DTO: 필드명이 계약)
    @PostMapping("/member2")
    public String memberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}