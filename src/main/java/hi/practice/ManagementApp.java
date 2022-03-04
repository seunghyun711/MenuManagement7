package hi.practice;

import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import hi.practice.menu.MenuService;
import hi.practice.menu.MenuServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManagementApp {

    public static void main(String[] args) {
//        MenuService menuService = new MenuServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MenuService menuService = appConfig.menuService();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MenuService menuService = ac.getBean("menuService",MenuService.class);
        Menu menu = new Menu(1L,"ShrimpBurger", EventMenu.ShrimpBurger);
        menuService.menuRegistration(menu);

        Menu findMenu = menuService.findMenu("ShrimpBurger");
        System.out.println("Registered Menu = " + menu.getName());
        System.out.println("find Menu = " + findMenu.getName());

        Menu deleteMenu = menuService.removeMenu(1L);
        System.out.println("Removed Menu : " + menu.getId()+ " " + menu.getName());


    }
}
