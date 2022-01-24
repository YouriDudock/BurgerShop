package main.com.burgershop.data.entity.order;

import main.com.burgershop.data.model.order.Order;

/**
 * A menu order is an order that contains a preset of addition ids combined with a burger
 *
 * @author Youri Dudock
 */
public class MenuOrder extends Order {

    /**
     * Id of the menu
     */
    private final int menuId;

    public MenuOrder(int menuId, int burgerId, int[] additionIds) {
        super(burgerId);
        this.menuId = menuId;
        super.additionIds = additionIds;
    }

    public int getMenuId() {
        return menuId;
    }
}
