package main.com.burgershop.core;

import main.com.burgershop.data.entity.burger.Bread;
import main.com.burgershop.data.entity.burger.Burger;
import main.com.burgershop.data.entity.burger.topping.Meat;
import main.com.burgershop.data.entity.burger.topping.Topping;
import main.com.burgershop.data.entity.order.OrderAddition;
import main.com.burgershop.data.model.order.Order;
import main.com.burgershop.data.model.order.ProcessedOrder;
import main.com.burgershop.data.repository.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


/**
 * The shop deals the ordering of the burgers
 *
 * @author Youri Dudock
 */
public class Shop {

    private final BurgerRepository burgerRepository;

    private final ToppingRepository toppingRepository;

    private final OrderAdditionRepository orderAdditionRepository;

    private final BurgerMeatRepository burgerMeatRepository;

    private final BurgerBreadRepository burgerBreadRepository;

    private final MenuOrderRepository menuOrderRepository;


    public Shop(BurgerRepository burgerRepository, ToppingRepository toppingRepository, OrderAdditionRepository orderAdditionRepository, BurgerMeatRepository burgerMeatRepository, BurgerBreadRepository burgerBreadRepository, MenuOrderRepository menuOrderRepository) {
        this.burgerRepository = burgerRepository;
        this.toppingRepository = toppingRepository;
        this.orderAdditionRepository = orderAdditionRepository;
        this.burgerMeatRepository = burgerMeatRepository;
        this.burgerBreadRepository = burgerBreadRepository;
        this.menuOrderRepository = menuOrderRepository;
    }

    /**
     * Handles a single order
     *
     * @param order the order that must be processed
     *
     * @return the processed order
     */
    public ProcessedOrder order(Order order) {
        // first get and validate toppings so that we can construct and validate the burger
        // list with all the toppings based on the order
        ArrayList<Topping> toppings = getAndValidateToppings(order.getToppingIds());

        // get and validate burger on order
        Burger burger = getAndValidateBurger(order.getBurgerId(), order.getBreadId(), order.getMeatId(), toppings);

        // list with all order additions based on the order
        ArrayList<OrderAddition> orderAdditions = getAndValidateOrderAdditions(order.getAdditionIds());

        // create processed order based on current order
        ProcessedOrder processedOrder = new ProcessedOrder(burger, orderAdditions);

        // return processed order
        return processedOrder;
    }

    /**
     * Gets, constructs and validates a burger from the repository
     * Can throw exception when any data is incorrect
     *
     * @param burgerId the id of the burger to get
     * @param breadId the id of the bread of the burger
     * @param meatId the id of the meat on the burger
     * @param toppings the toppings present on the burger
     * @return an instance of a burger for this order
     */
    private Burger getAndValidateBurger(int burgerId, Optional<Integer> breadId, Optional<Integer> meatId, ArrayList<Topping> toppings) {
        // first check if bread & meat are present
        if (breadId.isEmpty() || meatId.isEmpty()) {
            throw new InvalidParameterException("The burger has no selected bread or meat.");
        }

        // get burger from repository by id
        Optional<Burger> burger = burgerRepository.getBurger(burgerId);

        // check if burger exists
        if (burger.isEmpty()) {
            throw new InvalidParameterException("The burger with id " + burgerId + " does not exist");
        }

        // get the max toppings allowed on this burger
        int maxToppings = burger.get().getToppings().length;

        // check if there are no more toppings on this burger than allowed
        if (toppings.size() > maxToppings) {
            throw new InvalidParameterException("This burger exceeds the maximal possible toppings for this specific burger.");
        }

        // set the toppings in the burger
        for (int i = 0; i < toppings.size(); i++) {
            burger.get().getToppings()[i] = toppings.get(i);
        }

        // get chosen burger bread
        Optional<Bread> burgerBread = burgerBreadRepository.getBurgerBread(breadId.get());

        // check if bread exists
        if (burgerBread.isEmpty()) {
            throw new InvalidParameterException("The burger bread with id " + breadId + " does not exist");
        }

        // set the bread of the burger
        burger.get().setBread(burgerBread.get());

        // get chosen burger meat
        Optional<Meat> burgerMeat = burgerMeatRepository.getBurgerMeat(meatId.get());

        // check if bread exists
        if (burgerMeat.isEmpty() ) {
            throw new InvalidParameterException("The burger meat with id " + breadId + " does not exist");
        }

        // set the meat of the burger
        burger.get().setMeat(burgerMeat.get());

        // return the burger
        return burger.get();
    }

    /**
     * Gets and validates the toppings based on the repository
     * Can throw exception when a topping does not exist
     *
     * @param toppingIds ids of the toppings to get and validate
     *
     * @return instances of the toppings that match the id of the given parameter
     */
    private ArrayList<Topping> getAndValidateToppings(int[] toppingIds) {
        ArrayList<Topping> toppings = new ArrayList<>();

        // check if there are any toppings
        if (toppingIds == null) {
            return toppings;
        }

        // convert topping ids to topping instances
        Arrays.stream(toppingIds).forEach(toppingId -> {
            Optional<Topping> topping = toppingRepository.getTopping(toppingId);

            if (topping.isEmpty()) {
                throw new InvalidParameterException("Topping with id " + toppingId + " does not exist.");
            }

            // add topping instance to the list
            toppings.add(topping.get());
        });

        return toppings;
    }

    /**
     * Gets and validates the additions based on the repository
     * Can throw exception when an addition does not exist
     *
     * @param orderAdditionIds ids of the additions to get and validate
     *
     * @return instances of the additions that match the id of the given parameter
     */
    private ArrayList<OrderAddition> getAndValidateOrderAdditions(int[] orderAdditionIds) {
        ArrayList<OrderAddition> orderAdditions = new ArrayList<>();

        // check if there are any additions
        if (orderAdditionIds == null) {
            return orderAdditions;
        }

        // convert order additions ids to order additions instances
        Arrays.stream(orderAdditionIds).forEach(orderAdditionId -> {
            Optional<OrderAddition> orderAddition = orderAdditionRepository.getOrderAddition(orderAdditionId);

            if (orderAddition.isEmpty()) {
                throw new InvalidParameterException("Order addition with id " + orderAdditionId + " does not exist.");
            }

            orderAdditions.add(orderAddition.get());
        });

        return orderAdditions;
    }




}
