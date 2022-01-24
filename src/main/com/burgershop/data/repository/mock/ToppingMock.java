package main.com.burgershop.data.repository.mock;

import main.com.burgershop.data.entity.burger.topping.Topping;

import java.math.BigDecimal;

/**
 * @author Youri Dudock
 */
public enum ToppingMock {

    CHEESE(new Topping(0, "Cheese", new BigDecimal("0.50"))),
    KETCHUP(new Topping(1, "Ketchup", new BigDecimal("0.35"))),
    LETTUCE(new Topping(2, "Lettuce", new BigDecimal("0.20"))),
    TOMATO(new Topping(3, "Tomato", new BigDecimal("0.20"))),
    UNION(new Topping(4, "Union", new BigDecimal("0.15"))),
    CURRY(new Topping(5, "Curry", new BigDecimal("0.35")));


    private final Topping topping;

    private ToppingMock(Topping topping) {
        this.topping = topping;
    }

    public Topping getInstance() {
        return topping;
    }
}
