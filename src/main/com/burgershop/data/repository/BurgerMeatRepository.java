package main.com.burgershop.data.repository;

import main.com.burgershop.data.entity.burger.topping.Meat;
import main.com.burgershop.data.repository.mock.MeatMock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author Youri Dudock
 */
public class BurgerMeatRepository extends Repository {

    public List<Meat> getBurgerMeats() {
        // get all burger meat from mock enum
        MeatMock[] meatMocks = MeatMock.values();

        // cast mock enum values to burger meat instances array
        return Arrays.stream(meatMocks).map(MeatMock::getInstance).toList();
    }

    public Optional<Meat> getBurgerMeat(int meatId) {
        return getBurgerMeats().stream().filter(meat -> meat.getId() == meatId).findFirst();
    }


}
