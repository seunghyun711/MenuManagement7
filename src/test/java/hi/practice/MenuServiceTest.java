package hi.practice;

import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import hi.practice.menu.MenuService;
import hi.practice.menu.MenuServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuServiceTest {

    MenuService menuService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        menuService = appConfig.menuService();
    }

    @Test
    @DisplayName("메뉴 등록 테스트")
    void MenuRegistration(){

        //given
        Menu menu = new Menu(1L,"ShrimpBurger", EventMenu.ShrimpBurger);

        //when
        menuService.menuRegistration(menu);
        Menu findMenu = menuService.findMenu("ShrimpBurger");

        //then
        Assertions.assertThat(menu).isEqualTo(findMenu);
    }

    @Test
    @DisplayName("메뉴 삭제 테스트")
    void removeMenu(){
        //given
        Menu menu = new Menu(1L,"ShrimpBurger",EventMenu.ShrimpBurger);

        //when
        Menu removed = menuService.removeMenu(1L);

        //then
        Assertions.assertThat(removed).isNotIn(menu);
    }
}
