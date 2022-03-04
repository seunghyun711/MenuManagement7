package hi.practice.discount;

import hi.practice.menu.Menu;

public interface DiscountPolicy {
    int discount(Menu menu, int price);
}
