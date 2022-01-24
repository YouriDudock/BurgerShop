package main.com.burgershop.data.entity.burger.topping;

/**
 * The meat on a burger
 *
 * @author Youri Dudock
 */
public class Meat {

    /**
     * The id of the meat
     */
    private final int id;

    /**
     * The name of the meat
     */
    private final String name;

    public Meat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
