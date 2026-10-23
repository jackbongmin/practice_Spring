package org.example.practice_spring.day03_api.dto;


/**
 * 회원값 3개(name, email, organization)를 한번에 담는 그릇
 * - Get 쿼리스트링 -> 컨트롤러 매개변수에 그대로 선언하면 필드명으로 자동 바인딩된다.
 * - POST/PUT JSON  -> @RequestBody와 함께 쓰면 JSON key와 필드명이 매칭된다.
 * - 값이 안들어온 필드는 null이 된다.(예외가 아님.)
 */
public record MemberDto(String name, String email, String organization) {
}
