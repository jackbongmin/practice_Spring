package org.example.practice_spring.day03_api.exception;

import org.example.practice_spring.day03_api.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 컨트롤러에서 던져진 예외를 한곳에서 받아 "상태코드 + 통일된 JSON" 으로 바꾸는 전역 처리기.
 * - 컨트롤러마다 try/catch 를 쓰지 않아도 되게 하려고 만든다.
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    // 없는 id 조회/수정/삭제 -> 404
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(MemberNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(404, e.getMessage()));
    }

    // @Valid 검증 실패 -> 400 (실패한 필드의 첫 메시지를 담는다)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> invalid(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(new ErrorResponse(400, message));
    }
}