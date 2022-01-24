package main.com.burgershop.data.repository;

import main.com.burgershop.data.entity.burger.Bread;
import main.com.burgershop.data.repository.mock.BreadMock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author Youri Dudock
 */
public class BurgerBreadRepository extends Repository {

    public List<Bread> getBurgerBreads() {
        // get all burgers bread from mock enum
        BreadMock[] breadMocks = BreadMock.values();

        // cast mock enum values to burger bread instances array
        return Arrays.stream(breadMocks).map(BreadMock::getInstance).toList();
    }

    public Optional<Bread> getBurgerBread(int breadId) {
        return getBurgerBreads().stream().filter(bread -> bread.getId() == breadId).findFirst();
    }

}
