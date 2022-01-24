package main.com.burgershop.data.repository.mock;

import main.com.burgershop.data.entity.order.MenuOrder;

/**
 * @author Youri Dudock
 */
public enum MenuOrderMock {


    COMBO_BURGER_WITH_CHIPS_AND_DRINKS(
            new MenuOrder(0, BurgerMock.COMBO_BURGER.getInstance().getId(),
                    new int[] {
                            OrderAdditionMock.CHIPS.getInstance().getId(),
                            OrderAdditionMock.COLA.getInstance().getId()
                    })
    );


    private final MenuOrder menu;

    private MenuOrderMock(MenuOrder menu) {
        this.menu = menu;
    }

    public MenuOrder getInstance() {
        return menu;
    }
}
