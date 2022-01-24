package main.com.burgershop.data.entity.burger.topping;

import java.math.BigDecimal;

/**
 * The topping that is on a burger
 *
 * @author Youri Dudock
 */
public class Topping {

    /**
     * The id of the topping
     */
    private final int id;

    /**
     * The name of the topping
     */
    private final String name;

    /**
     * The price of the topping
     */
    private final BigDecimal price;

    public Topping(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
