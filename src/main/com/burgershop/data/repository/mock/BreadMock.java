package main.com.burgershop.data.repository.mock;

import main.com.burgershop.data.entity.burger.Bread;

/**
 * @author Youri Dudock
 */
public enum BreadMock {

    WHOLEGRAIN(new Bread(0, "Wholegrain")),
    WHITE(new Bread(1, "White")),
    BRIOCHE(new Bread(2, "Brioche")),
    CIABATTA(new Bread(3, "Ciabatta"));


    private final Bread bread;

    private BreadMock(Bread bread) {
        this.bread = bread;
    }

    public Bread getInstance() {
        return bread;
    }
}
