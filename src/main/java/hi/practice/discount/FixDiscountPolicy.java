package hi.practice.discount;

import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 2000; // 2000원 할인

    @Override
    public int discount(Menu menu, int price) {
        if(menu.getEventMenu() == EventMenu.ShrimpBurger){
            return discountFixAmount; // 주문한 메뉴가 ShrimpBurger 이면, 할인
        }else{
            return 0;
        }
    }
}
