package org.example.practice_spring.day03_api.controller;

import org.example.practice_spring.day03_api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 반환 타입에 따라 응답이 어떻게 달라지는지 보는 PUT 연습용 컨트롤러.
 * - String            -> 글자 그대로 (200)
 * - MemberDto         -> JSON 으로 자동 변환 (200)
 * - ResponseEntity<T> -> status / header / body 를 직접 지정
 */

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping("/member1")
    public String asString(@RequestBody MemberDto dto) {
        return dto.toString();
    }

    @PutMapping("/member2")
    public MemberDto asJson(@RequestBody MemberDto dto) {
        return dto;
    }

    // 200 이 아닌 202 Accepted 로 응답
    @PutMapping("/member3")
    public ResponseEntity<MemberDto> asEntity(@RequestBody MemberDto dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }
}