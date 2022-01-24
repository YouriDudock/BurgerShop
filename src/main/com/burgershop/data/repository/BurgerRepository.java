package main.com.burgershop.data.repository;

import main.com.burgershop.data.entity.burger.Burger;
import main.com.burgershop.data.repository.mock.BurgerMock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author Youri Dudock
 */
public class BurgerRepository extends Repository {

    public List<Burger> getBurgers() {
        // get all burgers from mock enum
        BurgerMock[] burgerMocks = BurgerMock.values();

        // cast mock enum values to burger instances array
        return Arrays.stream(burgerMocks).map(BurgerMock::getInstance).toList();
    }

    public Optional<Burger> getBurger(int burgerId) {
        return getBurgers().stream().filter(burger -> burger.getId() == burgerId).findFirst();
    }



}
