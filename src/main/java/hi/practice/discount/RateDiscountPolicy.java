package hi.practice.discount;

import hi.practice.annotation.MainDiscountPolicy;
import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 20; //20% 할인

    @Override
    public int discount(Menu menu, int price) {
        if(menu.getEventMenu() == EventMenu.ShrimpBurger){
            return price * discountPercent /100;
        }else{
            return 0;
        }
    }
}
