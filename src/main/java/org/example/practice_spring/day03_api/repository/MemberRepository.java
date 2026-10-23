package org.example.practice_spring.day03_api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.example.practice_spring.day03_api.dto.MemberRequest;
import org.example.practice_spring.day03_api.dto.MemberResponse;
import org.springframework.stereotype.Repository;

/**
 * DB 대신 메모리(Map)에 회원을 저장하는 저장소.
 * - 아직 DB 를 배우지 않았으므로 "저장 -> 조회로 확인" 흐름만 체험하기 위한 임시 구현이다.
 * - 서버를 재시작하면 데이터가 사라진다. 나중에 JPA 로 교체해도 컨트롤러가 거의 안 바뀌게 메서드를 단순하게 둔다.
 */

@Repository
public class MemberRepository {

    private final Map<Long, MemberResponse> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();   // id 자동 발급기

    public MemberResponse save(MemberRequest r) {
        long id = sequence.incrementAndGet();
        MemberResponse saved = new MemberResponse(id, r.name(), r.email(), r.organization());
        store.put(id, saved);
        return saved;
    }

    public Optional<MemberResponse> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<MemberResponse> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<MemberResponse> update(Long id, MemberRequest r) {
        if(!store.containsKey(id)) {
            return Optional.empty();
        }
        MemberResponse updated = new MemberResponse(id, r.name(), r.email(), r.organization());
        store.put(id, updated);
        return Optional.of(updated);
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}