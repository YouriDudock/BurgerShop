package main.com.burgershop.data.repository.mock;

import main.com.burgershop.data.entity.order.OrderAddition;

import java.math.BigDecimal;

/**
 * @author Youri Dudock
 */
public enum OrderAdditionMock {

    CHIPS(new OrderAddition(0, "Chips", new BigDecimal("1.50"))),
    COLA(new OrderAddition(1, "Cola", new BigDecimal("2.00")));

    private final OrderAddition orderAddition;

    private OrderAdditionMock(OrderAddition orderAddition) {
        this.orderAddition = orderAddition;
    }

    public OrderAddition getInstance() {
        return orderAddition;
    }
}
