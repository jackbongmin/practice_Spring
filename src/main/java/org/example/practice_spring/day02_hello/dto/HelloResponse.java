package org.example.practice_spring.day02_hello.dto;

/**
 * React 에게 돌려줄 JSON 한 건의 모양 -> {"id":3333,"name":"영희","age":30}
 * - record 는 필드(id, name, age)에 대한 getter 를 자동으로 만들어 주고, 스프링(Jackson)이 이를 JSON 으로 변환한다.
 */
public record HelloResponse(Long id, String name, int age) {
}