package org.example.practice_spring.day03_api.exception;

/**
 * "해당 id 의 회원이 없다"를 나타내는 예외. ApiExceptionHandler 가 이를 404 로 바꿔 준다.
 */
public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id) {
        super("회원을 찾을 수 없습니다. id=" + id);
    }
}