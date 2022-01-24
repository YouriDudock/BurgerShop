package main.com.burgershop.data.entity.order;

import java.math.BigDecimal;

/**
 * An order addition is an addition to the order besides the burger, this could be things like chips etc
 *
 * @author Youri Dudock
 */
public class OrderAddition {

    /**
     * Id of the order addition
     */
    private final int id;

    /**
     * Name of the order addition
     */
    private final String name;

    /**
     * Price of the order addition
     */
    private final BigDecimal price;

    public OrderAddition(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
