package org.example.practice_spring.day03_api.dto;

/**
 * 서버가 돌려주는 회원 한 명의 모양. 요청(MemberRequest)과 달리 서버가 발급한 id 가 들어 있다.
 * - 요청/응답 DTO 를 분리하면 "클라이언트가 id 를 마음대로 정하는" 일을 구조적으로 막는다.
 */
public record MemberResponse(Long id, String name, String email, String organization) {
}