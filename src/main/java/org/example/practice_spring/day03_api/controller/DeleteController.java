package org.example.practice_spring.day03_api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DELETE 도 GET 처럼 path / query 로 값을 받는다 (body 를 쓰지 않는 게 관례).
 * 이 클래스는 "받기만 하고 실제로 지우지는 않는" 연습용이다. 진짜 삭제는 Step 6 의 MemberController 에서 한다.
 */
@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // DELETE /api/v1/delete-api/hong
    @DeleteMapping("/{variable}")
    public String byPath(@PathVariable String variable) {
        return variable;
    }

    // DELETE /api/v1/delete-api/request1?email=k@x.com
    @DeleteMapping("/request1")
    public String byQuery(@RequestParam String email) {
        return "e-mail : " + email;
    }
}