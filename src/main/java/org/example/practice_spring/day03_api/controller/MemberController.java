package org.example.practice_spring.day03_api.controller;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.practice_spring.day03_api.dto.MemberRequest;
import org.example.practice_spring.day03_api.dto.MemberResponse;
import org.example.practice_spring.day03_api.exception.MemberNotFoundException;
import org.example.practice_spring.day03_api.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 오늘 배운 GET/POST/PUT/DELETE 를 "회원"이라는 하나의 자원에 모아 만든 REST CRUD API.
 * - 같은 URL(/api/v1/members)을 HTTP 메서드로 구분한다: 목록(GET) / 등록(POST) / 수정(PUT) / 삭제(DELETE)
 * - 상태코드까지 의미 있게 돌려주는 것이 앞의 연습용 컨트롤러와의 차이다.
 */
@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository repository;

    // 200 + 배열
    @GetMapping
    public List<MemberResponse> list() {
        return repository.findAll();
    }

    // 200 + 객체 / 없으면 404
    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
    }

    // 201 Created + Location 헤더 + 만들어진 객체
    @PostMapping
    public ResponseEntity<MemberResponse> create(@Valid @RequestBody MemberRequest request) {
        MemberResponse saved = repository.save(request);
        return ResponseEntity.created(URI.create("/api/v1/members/" + saved.id())).body(saved);
    }

    // 200 + 수정된 객체 / 없으면 404
    @PutMapping("/{id}")
    public MemberResponse update(@PathVariable Long id, @Valid @RequestBody MemberRequest request) {
        return repository.update(id, request).orElseThrow(() -> new MemberNotFoundException(id));
    }

    // 204 No Content (본문 없음) / 없으면 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.delete(id)) {
            throw new MemberNotFoundException(id);
        }
        return ResponseEntity.noContent().build();
    }
}