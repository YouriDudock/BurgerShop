package main.com.burgershop.data.model.order;

import java.util.Optional;

/**
 * An order is an order for a burger in the shop, plus with the extra specifications such as bread, toppings and additions
 *
 * @author Youri Dudock
 */
public class Order {

    /**
     * Id of the burger in the order
     */
    private final int burgerId;

    /**
     * Id of the bread as optional, so we can check if it was set or not
     */
    private Optional<Integer> breadId;

    /**
     * Id of the meat as optional, so we can check if it was set or not
     */
    private Optional<Integer> meatId;

    /**
     * All the toppings in this order
     */
    private int[] toppingIds;

    /**
     * All the additions in this order
     */
    protected int[] additionIds;


    public Order(int burgerId) {
        this.burgerId = burgerId;
        breadId = Optional.empty();
        meatId = Optional.empty();
    }




    public int getBurgerId() {
        return burgerId;
    }


    public int[] getToppingIds() {
        return toppingIds;
    }

    public void setToppingIds(int[] toppingIds) {
        this.toppingIds = toppingIds;
    }

    public int[] getAdditionIds() {
        return additionIds;
    }

    public void setAdditionIds(int[] additionIds) {
        this.additionIds = additionIds;
    }

    public Optional<Integer> getBreadId() {
        return breadId;
    }

    public Optional<Integer> getMeatId() {
        return meatId;
    }

    public void setBreadId(int breadId) {
        this.breadId = Optional.of(breadId);
    }

    public void setMeatId(int meatId) {
        this.meatId = Optional.of(meatId);
    }
}
