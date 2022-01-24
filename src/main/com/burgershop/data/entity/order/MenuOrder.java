package main.com.burgershop.data.entity.order;

import main.com.burgershop.data.model.order.Order;

/**
 * @author Youri Dudock
 */
public class MenuOrder extends Order {

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
