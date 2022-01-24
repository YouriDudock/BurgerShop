package main.com.burgershop.data.repository;

import main.com.burgershop.data.entity.order.MenuOrder;
import main.com.burgershop.data.repository.mock.MenuOrderMock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author Youri Dudock
 */
public class MenuOrderRepository extends Repository {

    public List<MenuOrder> GetMenuOrders() {
        // get all menu orders from mock enum
        MenuOrderMock[] menuOrderMocks = MenuOrderMock.values();

        // cast mock enum values to menu orders instances array
        return Arrays.stream(menuOrderMocks).map(MenuOrderMock::getInstance).toList();
    }

    public Optional<MenuOrder> getMenuOrder(int menuOrderId) {
        return GetMenuOrders().stream().filter(menuOrder -> menuOrder.getMenuId() == menuOrderId).findFirst();
    }

}
