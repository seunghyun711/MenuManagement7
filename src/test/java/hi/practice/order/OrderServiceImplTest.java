package hi.practice.order;

import hi.practice.discount.FixDiscountPolicy;
import hi.practice.menu.EventMenu;
import hi.practice.menu.MemoryMenuRepository;
import hi.practice.menu.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMenuRepository menuRepository = new MemoryMenuRepository();
        menuRepository.save(new Menu(1L,"ShrimpBurger", EventMenu.ShrimpBurger));

        OrderServiceImpl orderService = new OrderServiceImpl(menuRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "ShrimpBurger", 5000);
        assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}
