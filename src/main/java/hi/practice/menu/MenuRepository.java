package hi.practice.menu;

public interface MenuRepository {

    void save(Menu menu); // 새 메뉴 등록

    Menu findByName(String menuName); // 메뉴 찾기

    Menu delete(Long id); // 메뉴 삭제
}
