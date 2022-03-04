package hi.practice.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @Override
    public void menuRegistration(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public Menu findMenu(String menuName) {
        return menuRepository.findByName(menuName);
    }

    @Override
    public Menu removeMenu(Long menuId) {
        return menuRepository.delete(menuId);
    }

    // 테스트 용도
    public MenuRepository getMenuRepository(){
        return menuRepository;
    }
}
