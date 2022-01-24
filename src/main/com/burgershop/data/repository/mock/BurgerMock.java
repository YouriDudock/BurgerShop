package main.com.burgershop.data.repository.mock;

import main.com.burgershop.data.entity.burger.Burger;

import java.math.BigDecimal;

/**
 * @author Youri Dudock
 */
public enum BurgerMock {

    BASIC_BURGER(new Burger(0, "Basic Burger", 4, new BigDecimal(5))),
    HEALTHY_BURGER(new Burger(1, "Healthy Burger", 6, new BigDecimal(8))),
    COMBO_BURGER(new Burger(2, "Combo Burger",0, new BigDecimal(7)));

    private final Burger burger;

    private BurgerMock(Burger burger) {
        this.burger = burger;
    }

    public Burger getInstance() {
        return burger;
    }
}
