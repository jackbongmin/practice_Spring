plugins {
    java
    id("org.springframework.boot") version "4.1.1"          // Boot 버전, 실행, 패키징 담당
    id("io.spring.dependency-management") version "1.1.7"   // 의존성 버전을 boot가 일괄 관리
}

group = "org.example"
version = "0.0.1-SNAPSHOT"
description = "practice_spring"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)    // 요구 자바 버전
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")   // 이 프로젝트는 웹이다.를 알림 / 내장 Tomcat + Spring MVC
    compileOnly("org.projectlombok:lombok")                                 // 보일러플레이트 코드 자동 생성(롬복)
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")  // 테스트 도구 모음
    testCompileOnly("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
