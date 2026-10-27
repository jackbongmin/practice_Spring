package org.example.practice_spring.day05_jpa.data.repository;

import org.example.practice_spring.day05_jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<엔티티, @Id 필드타입>를 상속하면 save / findById / delete 등이 이미 들어있다.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
