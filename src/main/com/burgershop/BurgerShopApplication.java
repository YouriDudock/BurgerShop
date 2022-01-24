package main.com.burgershop;

import main.com.burgershop.core.Shop;
import main.com.burgershop.data.entity.burger.topping.Topping;
import main.com.burgershop.data.entity.order.MenuOrder;
import main.com.burgershop.data.entity.order.OrderAddition;
import main.com.burgershop.data.model.order.Order;
import main.com.burgershop.data.model.order.ProcessedOrder;
import main.com.burgershop.data.repository.*;
import main.com.burgershop.data.repository.mock.*;

import java.util.Optional;

/**
 * The burger shop application is responsible for the ordering of different kind of burgers with specifications
 *
 * @author Youri Dudock
 */
public class BurgerShopApplication {

    private static MenuOrderRepository menuOrderRepository;
    private static BurgerRepository burgerRepository;
    private static ToppingRepository toppingRepository;
    private static OrderAdditionRepository orderAdditionRepository;
    private static BurgerMeatRepository burgerMeatRepository;
    private static BurgerBreadRepository burgerBreadRepository;



    public static void main(String[] args) {
        // init the repos
        initRepos();

        // create shop instance
        Shop shop = new Shop(burgerRepository, toppingRepository, orderAdditionRepository, burgerMeatRepository, burgerBreadRepository, menuOrderRepository);

        // order a basic burger
        Order basicBurgerOrder = new Order(BurgerMock.BASIC_BURGER.getInstance().getId());

        // set the bread and meat types
        basicBurgerOrder.setBreadId(BreadMock.WHITE.getInstance().getId());
        basicBurgerOrder.setMeatId(MeatMock.BLACK_ANGUS_PATTY.getInstance().getId());

        // set the toppings
        basicBurgerOrder.setToppingIds(new int[] {
                ToppingMock.CHEESE.getInstance().getId(),
                ToppingMock.KETCHUP.getInstance().getId(),
                ToppingMock.LETTUCE.getInstance().getId(),
                ToppingMock.UNION.getInstance().getId()
        });

        // order and fetch order result
        ProcessedOrder basicBurgerProcessedOrder = shop.order(basicBurgerOrder);

        // out print order
        outPrintOrder(basicBurgerProcessedOrder);



        // order a health burger
        Order healthyBurgerOrder = new Order(BurgerMock.HEALTHY_BURGER.getInstance().getId());

        // set bread and meat types
        healthyBurgerOrder.setBreadId(BreadMock.WHITE.getInstance().getId());
        healthyBurgerOrder.setMeatId(MeatMock.BLACK_ANGUS_PATTY.getInstance().getId());

        // set toppings
        healthyBurgerOrder.setToppingIds(new int[] {
                ToppingMock.CHEESE.getInstance().getId(),
                ToppingMock.KETCHUP.getInstance().getId(),
                ToppingMock.LETTUCE.getInstance().getId(),
                ToppingMock.UNION.getInstance().getId(),
                ToppingMock.TOMATO.getInstance().getId(),
                ToppingMock.CURRY.getInstance().getId()
        });

        // order and fetch order result
        ProcessedOrder healthyBurgerProcessedOrder = shop.order(healthyBurgerOrder);

        // out print order
        outPrintOrder(healthyBurgerProcessedOrder);




        // order a combo burger based off a menu
        Optional<MenuOrder> comboBurgerOrder = menuOrderRepository.getMenuOrder(MenuOrderMock.COMBO_BURGER_WITH_CHIPS_AND_DRINKS.getInstance().getMenuId());

        // check if menu exists
        if (comboBurgerOrder.isPresent()) {
            // set bread and meat types
            comboBurgerOrder.get().setBreadId(BreadMock.WHITE.getInstance().getId());
            comboBurgerOrder.get().setMeatId(MeatMock.BLACK_ANGUS_PATTY.getInstance().getId());

            // order and fetch order result
            ProcessedOrder comboBurgerProcessedOrder = shop.order(comboBurgerOrder.get());

            // out print order
            outPrintOrder(comboBurgerProcessedOrder);
        }



    }

    /**
     * Inits all the repos present in this application during startup
     */
    private static void initRepos() {
        // init repos
        menuOrderRepository = new MenuOrderRepository();
        burgerRepository = new BurgerRepository();
        toppingRepository = new ToppingRepository();
        orderAdditionRepository = new OrderAdditionRepository();
        burgerMeatRepository = new BurgerMeatRepository();
        burgerBreadRepository = new BurgerBreadRepository();
    }

    /**
     * Out prints a processed order
     *
     * @param order the processed order to print out
     */
    private static void outPrintOrder(ProcessedOrder order) {
        System.out.println("Burger name: " + order.getBurger().getName() + ", price: " + order.getBurger().getPrice());
        System.out.println("Burger bread: " + order.getBurger().getBread().getName() + ", Burger meat: " + order.getBurger().getMeat().getName());

        for (Topping topping : order.getBurger().getToppings()) {
            System.out.println("Topping name: " + topping.getName() + ", price: " + topping.getPrice());
        }

        for (OrderAddition orderAddition : order.getOrderAdditions()) {
            System.out.println("Order addition name: " + orderAddition.getName() + ", price: " + orderAddition.getPrice());
        }

        System.out.println("Total cost: " + order.getTotalOrderCost());

        System.out.println();
    }



}
