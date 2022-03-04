package hi.practice.order;

public interface OrderService {
    Order createOrder(Long menuId, String menuName, int menuPrice);
}
