package org.example.practice_spring.day01_di;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.practice_spring.day01_di.controller.DIController;
import org.example.practice_spring.day01_di.controller.FieldInjectionController;
import org.example.practice_spring.day01_di.controller.NoDIController;
import org.example.practice_spring.day01_di.controller.SetterInjectionController;
import org.example.practice_spring.day01_di.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day01DiTest {

    @Autowired NoDIController noDiController;
    @Autowired DIController diController;
    @Autowired FieldInjectionController fieldController;
    @Autowired SetterInjectionController setterController;
    @Autowired MyService myService;

    @Test
    void 두_컨트롤러는_같은_문자열을_돌려준다() {
        assertThat(noDiController.getHello()).isEqualTo("Hello");
        assertThat(diController.getHello()).isEqualTo("Hello");
    }

    @Test
    void 세_가지_주입_방식_모두_같은_Bean이_들어온다() {
        assertThat(fieldController.getMyService()).isSameAs(myService);
        assertThat(setterController.getMyService()).isSameAs(myService);
    }

}
