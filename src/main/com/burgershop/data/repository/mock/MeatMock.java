package main.com.burgershop.data.repository.mock;

import main.com.burgershop.data.entity.burger.topping.Meat;

/**
 * @author Youri Dudock
 */
public enum MeatMock {


    BLACK_ANGUS_PATTY(new Meat(0, "Black Angus Patty")),
    KOBE_BEEF_PATTY(new Meat(1, "Kobe Beef Patty")),
    VEGAN_PATTY(new Meat(0, "Vegan Patty")),
    FISH_PATTY(new Meat(0, "Fish Patty"));


    private final Meat meat;

    private MeatMock(Meat meat) {
        this.meat = meat;
    }

    public Meat getInstance() {
        return meat;
    }
}
