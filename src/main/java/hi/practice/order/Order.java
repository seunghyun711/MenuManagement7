package hi.practice.order;

public class Order {

    private Long menuId;
    private String menuName;
    private int menuPrice;
    private int discountPrice;

    public Order(Long menuId, String menuName, int menuPrice, int discountPrice) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return menuPrice - discountPrice;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString(){
        return "Order{" + "menuId = " + menuId + ", menuName = " + menuName + '\'' +
                ", menuPrice = " + menuPrice + ", discountPrice = " + discountPrice + '}';
    }
}
