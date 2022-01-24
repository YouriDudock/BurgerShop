package main.com.burgershop.data.entity.order;

import java.math.BigDecimal;

/**
 * @author Youri Dudock
 */
public class OrderAddition {

    private final int id;

    private final String name;

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
