package hi.practice.singleton;

import hi.practice.AppConfig;
import hi.practice.menu.MenuService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때 마다 객체 생성
        MenuService menuService1 = appConfig.menuService();

        // 2. 조회 : 호출할 때 마다 객체 생성
        MenuService menuService2 = appConfig.menuService();

        // 참조값이 다른 것을 확인
        System.out.println("menuService1 = " + menuService1);
        System.out.println("menuService2 = " + menuService2);

        // menuService1 != menuService2
        assertThat(menuService1).isNotSameAs(menuService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회 : 호출할 때 마다 같은 객체 반환
        MenuService menuService1 = ac.getBean("menuService", MenuService.class);

        // 2. 조회 : 호출할 때 마다 같은 객체 반환
        MenuService menuService2 = ac.getBean("menuService", MenuService.class);

        // 참조값이 같은 것을 확인
        System.out.println("menuService1 = " + menuService1);
        System.out.println("menuService2 = " + menuService2);

        // menuService1 == menuService2
        assertThat(menuService1).isSameAs(menuService2);
    }
}
