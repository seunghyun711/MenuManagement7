package hi.practice.order;

import hi.practice.AppConfig;
import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import hi.practice.menu.MenuService;
import hi.practice.menu.MenuServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MenuService menuService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        menuService = appConfig.menuService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long menuId = 1L;
        Menu menu = new Menu(menuId, "ShrimpBurger", EventMenu.ShrimpBurger);
        menuService.menuRegistration(menu);

        Order order = orderService.createOrder(menuId,"ShrimpBurger",5000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
