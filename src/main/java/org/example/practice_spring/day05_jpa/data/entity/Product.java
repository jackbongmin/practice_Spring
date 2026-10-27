package org.example.practice_spring.day05_jpa.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DB의 product 테이블 한 행과 1:1로 대응되는 클래스
 * - jakarta.persistence.*: JPA가 읽는 애너테이션(테이블/column 번역 규칙)
 * - lombok.*             : 컴파일 때 getter / setter / 생성자 등을 만들어 주는 애너테이션
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "name") // toString() 에서 name 만 뺀다
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 번호는 DB(auto_increment)가 만든다.
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    // @Column 이 없어도 column 은 생긴다 (규칙을 덧붙이지 않았을 뿐)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}


