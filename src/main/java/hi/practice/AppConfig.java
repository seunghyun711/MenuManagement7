package hi.practice;

import hi.practice.discount.DiscountPolicy;
import hi.practice.discount.FixDiscountPolicy;
import hi.practice.discount.RateDiscountPolicy;
import hi.practice.menu.MemoryMenuRepository;
import hi.practice.menu.MenuRepository;
import hi.practice.menu.MenuService;
import hi.practice.menu.MenuServiceImpl;
import hi.practice.order.OrderService;
import hi.practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MenuService menuService() {
        System.out.println("call AppConfig.menuService");
        return new MenuServiceImpl(menuRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(menuRepository(), discountPolicy());
    }

    @Bean
    public MenuRepository menuRepository(){
        System.out.println("call AppConfig.menuRepository");
        return new MemoryMenuRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

}
