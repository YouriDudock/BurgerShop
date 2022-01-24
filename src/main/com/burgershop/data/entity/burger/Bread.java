package main.com.burgershop.data.entity.burger;

/**
 * The bread of a burger
 *
 * @author Youri Dudock
 */
public class Bread {

    /**
     * The id of the bread
     */
    private final int id;

    /**
     * The name of the bread
     */
    private final String name;

    public Bread(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
