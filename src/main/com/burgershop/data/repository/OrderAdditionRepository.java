package main.com.burgershop.data.repository;

import main.com.burgershop.data.entity.order.OrderAddition;
import main.com.burgershop.data.repository.mock.OrderAdditionMock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author Youri Dudock
 */
public class OrderAdditionRepository extends Repository {

    public List<OrderAddition> getOrderAdditions() {
        // get all order additions from mock enum
        OrderAdditionMock[] orderAdditions = OrderAdditionMock.values();

        // cast mock enum values to additions instances array
        return Arrays.stream(orderAdditions).map(OrderAdditionMock::getInstance).toList();
    }

    public Optional<OrderAddition> getOrderAddition(int orderAdditionId) {
        return getOrderAdditions().stream().filter(orderAddition -> orderAddition.getId() == orderAdditionId).findFirst();
    }


}
