package org.example.practice_spring.day03_api.dto;

/**
 * 모든 오류 응답의 공통 모양: {"status":404,"message":"..."}
 * - 오류마다 제각각이면 클라이언트(React)가 처리하기 어려워서 하나로 통일한다.
 */
public record ErrorResponse(int status, String message) {
}