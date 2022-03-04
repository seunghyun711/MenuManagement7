package hi.practice.discount;

import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("ShrimpBurger는 20% 할인이 적용된다.")
    void shrimpBugger_o(){
        //given
        Menu menu = new Menu(1L,"ShrimpBurger", EventMenu.ShrimpBurger);

        //when
        int discount = discountPolicy.discount(menu,5000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("ShrimpBurger가 아니면 할인이 적용되지 않는다.")
    void shrimpBurger_x(){
        //given
        Menu menu = new Menu(2L,"ChickenBurger",EventMenu.ChickenBurger);

        //when
        int discount = discountPolicy.discount(menu,4500);

        //then
        assertThat(discount).isEqualTo(0);
    }
}
