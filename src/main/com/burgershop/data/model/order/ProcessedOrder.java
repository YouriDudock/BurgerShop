package main.com.burgershop.data.model.order;

import main.com.burgershop.data.entity.burger.Burger;
import main.com.burgershop.data.entity.order.OrderAddition;
import main.com.burgershop.data.entity.burger.topping.Topping;

import java.math.BigDecimal;
import java.util.List;

/**
 * A processed order is an order that is finished and processed by the system.
 *
 * @author Youri Dudock
 */
public class ProcessedOrder {

    private final Burger burger;

    private final List<OrderAddition> orderAdditions;


    public ProcessedOrder(Burger burger, List<OrderAddition> orderAdditions) {
        this.burger = burger;
        this.orderAdditions = orderAdditions;
    }


    /**
     * Calculates the total cost of the order
     *
     * @return total order cost
     */
    public BigDecimal getTotalOrderCost() {
        BigDecimal total = BigDecimal.ZERO;

        total = total.add(burger.getPrice());

        for (Topping topping : burger.getToppings()) {
            total = total.add(topping.getPrice());
        }

        for (OrderAddition addition : orderAdditions) {
            total = total.add(addition.getPrice());
        }

        return total;
    }

    public Burger getBurger() {
        return burger;
    }


    public List<OrderAddition> getOrderAdditions() {
        return orderAdditions;
    }
}
