package hi.practice.singleton;

import hi.practice.AppConfig;
import hi.practice.menu.MenuRepository;
import hi.practice.menu.MenuServiceImpl;
import hi.practice.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MenuServiceImpl menuService = ac.getBean("menuService", MenuServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MenuRepository menuRepository = ac.getBean("menuRepository", MenuRepository.class);

        MenuRepository menuRepository1 = menuService.getMenuRepository();
        MenuRepository menuRepository2 = orderService.getMenuRepository();

        System.out.println("menuService -> menuRepository = " + menuRepository1);
        System.out.println("orderService -> menuRepository = " + menuRepository2);
        System.out.println("menuRepository = " + menuRepository);

        assertThat(menuService.getMenuRepository()).isSameAs(menuRepository);
        assertThat(orderService.getMenuRepository()).isSameAs(menuRepository);
    }

    @Test
    void configurationDepp(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
