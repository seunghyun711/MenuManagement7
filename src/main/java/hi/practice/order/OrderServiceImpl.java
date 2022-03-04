package hi.practice.order;

import hi.practice.annotation.MainDiscountPolicy;
import hi.practice.discount.DiscountPolicy;
import hi.practice.menu.Menu;
import hi.practice.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MenuRepository menuRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MenuRepository menuRepository,@MainDiscountPolicy DiscountPolicy DiscountPolicy){
        this.menuRepository = menuRepository;
        this.discountPolicy  = DiscountPolicy;
    }

    @Override
    public Order createOrder(Long menuId, String menuName, int menuPrice) {
        Menu menu = menuRepository.findByName(menuName);
        int discountPrice = discountPolicy.discount(menu, menuPrice);
        return new Order(menuId,menuName,menuPrice,discountPrice);
    }

    // 테스트 용도
    public MenuRepository getMenuRepository(){
        return menuRepository;
    }
}

