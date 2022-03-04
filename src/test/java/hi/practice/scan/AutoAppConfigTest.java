package hi.practice.scan;

import hi.practice.AutoAppConfig;
import hi.practice.discount.DiscountPolicy;
import hi.practice.menu.MenuRepository;
import hi.practice.menu.MenuService;
import hi.practice.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
       ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MenuService menuService = ac.getBean(MenuService.class);
        assertThat(menuService).isInstanceOf(MenuService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MenuRepository menuRepository = bean.getMenuRepository();
        System.out.println("menuRepository = " + menuRepository);
    }
}
