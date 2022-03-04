package hi.practice.beanfind;

import hi.practice.AppConfig;
import hi.practice.menu.MenuService;
import hi.practice.menu.MenuServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        MenuService menuService = ac.getBean("menuService",MenuService.class);
        assertThat(menuService).isInstanceOf(MenuServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findByType(){
        MenuService menuService = ac.getBean(MenuService.class);
        assertThat(menuService).isInstanceOf(MenuServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class, ()->
                ac.getBean("XX",MenuService.class));
    }
}
