package main.com.burgershop.data.entity.burger;

import main.com.burgershop.data.entity.burger.topping.Meat;
import main.com.burgershop.data.entity.burger.topping.Topping;

import java.math.BigDecimal;

/**
 * An entity representing a burger in the burger shop
 *
 * @author Youri Dudock
 */
public class Burger {

    /**
     * The id of the burger
     */
    private final int id;

    /**
     * The name of the burger
     */
    private final String name;

    /**
     * Burger price
     */
    private final BigDecimal price;

    /**
     * All toppings present on the burger
     */
    private final Topping[] toppings;

    /**
     * The chosen bread that the burger has
     */
    private Bread bread;

    /**
     * The chosen meat that the burger has
     */
    private Meat meat;


    public Burger(int id, String name, int toppingSize, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        toppings = new Topping[toppingSize];
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Topping[] getToppings() {
        return toppings;
    }

    public String getName() {
        return name;
    }
}
