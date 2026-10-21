package org.example.practice_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 애플리케이션 실행의 출발점(main class)
 *  - SpringBootApplication : 이 클래스의 패키지 아래쪽을 흝어 @Service, @RestController등을 Bean으로 등록(컴포넌트 스캔)하고 자동 설정을 켠다.
 *  - 고로 모든 실습 패키지의 상위에 있어야한다.
 *  - main(): SpringApplication.run으로 컨테이너와 내장 Tomcat을 띄운다.
 */

@SpringBootApplication
public class PracticeSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeSpringApplication.class, args);
    }

}
