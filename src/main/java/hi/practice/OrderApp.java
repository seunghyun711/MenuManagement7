package hi.practice;

import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import hi.practice.menu.MenuService;
import hi.practice.menu.MenuServiceImpl;
import hi.practice.order.Order;
import hi.practice.order.OrderService;
import hi.practice.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MenuService menuService = appConfig.menuService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MenuService menuService = ac.getBean("menuService", MenuService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        long menuId =1L;
        Menu menu = new Menu(menuId, "ShrimpBurger", EventMenu.ShrimpBurger);
        menuService.menuRegistration(menu);

        Order order = orderService.createOrder(menuId,"ShrimpBurger",5000);
        System.out.println("order = " + order);
    }
}
