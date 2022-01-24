package main.com.burgershop.data.repository;

import main.com.burgershop.data.entity.burger.topping.Topping;
import main.com.burgershop.data.repository.mock.ToppingMock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author Youri Dudock
 */
public class ToppingRepository extends Repository {

    public List<Topping> getToppings() {
        // get all toppings from mock enum
        ToppingMock[] toppingMocks = ToppingMock.values();

        // cast mock enum values to topping instances array
        return Arrays.stream(toppingMocks).map(ToppingMock::getInstance).toList();
    }



    public Optional<Topping> getTopping(int toppingId) {
        return getToppings().stream().filter(topping -> topping.getId() == toppingId).findFirst();
    }



}
