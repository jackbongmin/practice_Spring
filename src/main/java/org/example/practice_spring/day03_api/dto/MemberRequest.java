package org.example.practice_spring.day03_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * 회원 등록/수정 때 클라이언트가 보내는 JSON의 모양 + 입력 검증 규칙
 * - 검증 규칙을 DTO에 선언해 두면 컨트롤러는 @Valid 한 단어로 검증을 맡길 수 있다.
 */

public record MemberRequest(
        @NotBlank(message = "name은 필수입니다.") String name,
        @NotBlank(message = "email은 필수입니다.") @Email(message = "email 형식이 아닙니다.") String email,
        String organization) {
}
