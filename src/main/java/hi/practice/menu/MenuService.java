package hi.practice.menu;

public interface MenuService {

    // 메뉴 등록, 메뉴 조회, 메뉴 삭제 기능

    void menuRegistration(Menu menu);

    Menu findMenu(String menuName);

    Menu removeMenu(Long menuId);
}
