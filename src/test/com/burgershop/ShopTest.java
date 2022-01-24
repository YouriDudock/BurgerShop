package test.com.burgershop;

import main.com.burgershop.core.Shop;
import main.com.burgershop.data.entity.burger.Burger;
import main.com.burgershop.data.entity.order.MenuOrder;
import main.com.burgershop.data.model.order.Order;
import main.com.burgershop.data.model.order.ProcessedOrder;
import main.com.burgershop.data.repository.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the shop class
 */
class ShopTest {

    private MenuOrderRepository menuOrderRepository;
    private BurgerRepository burgerRepository;
    private ToppingRepository toppingRepository;
    private OrderAdditionRepository orderAdditionRepository;
    private BurgerMeatRepository burgerMeatRepository;
    private BurgerBreadRepository burgerBreadRepository;

    private Shop shop;

    public ShopTest() {
        initRepos();

        // TODO -> Interface repository mocking for tests
        shop = new Shop(burgerRepository, toppingRepository, orderAdditionRepository, burgerMeatRepository, burgerBreadRepository, menuOrderRepository);
    }

    @Test
    void testOrderSuccess() {
        Burger burger = new Burger(0, "Basic Burger", 4, new BigDecimal(5));

        // construct burger order
        Order order = new Order(burger.getId());
        order.setBreadId(1);
        order.setMeatId(1);

        order.setToppingIds(new int[] {
                0,
                1,
                2,
                3
        });

        order.setAdditionIds(new int[] {
                0,
                1
        });


        // order burger
        ProcessedOrder processedOrder = shop.order(order);

        // asserts burger values
        assertEquals(0, processedOrder.getBurger().getId());
        assertEquals("Basic Burger", processedOrder.getBurger().getName());
        assertEquals(4, processedOrder.getBurger().getToppings().length);
        assertEquals(new BigDecimal(5).intValueExact(), processedOrder.getBurger().getPrice().intValueExact());
        assertEquals(1, processedOrder.getBurger().getBread().getId());
        assertEquals(1, processedOrder.getBurger().getMeat().getId());

        // assert burger toppings
        assertEquals(0, processedOrder.getBurger().getToppings()[0].getId());
        assertEquals(1, processedOrder.getBurger().getToppings()[1].getId());
        assertEquals(2, processedOrder.getBurger().getToppings()[2].getId());
        assertEquals(3, processedOrder.getBurger().getToppings()[3].getId());

        // check if ids are still the same for additions
        assertEquals(0, processedOrder.getOrderAdditions().get(0).getId());
        assertEquals(1, processedOrder.getOrderAdditions().get(1).getId());

        // assert burger price
        assertEquals(new BigDecimal("9.75"), processedOrder.getTotalOrderCost());
    }


    @Test
    void testOrderTooManyToppings() {
        Burger burger = new Burger(0, "Basic Burger", 4, new BigDecimal(5));

        // construct burger order
        Order order = new Order(burger.getId());
        order.setBreadId(1);
        order.setMeatId(1);

        order.setToppingIds(new int[] {
                0,
                1,
                2,
                3,
                4
        });

        order.setAdditionIds(new int[] {
                0,
                1
        });


        // order burger
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            shop.order(order);
        });

    }

    @Test
    void testOrderNoBread() {
        Burger burger = new Burger(0, "Basic Burger", 4, new BigDecimal(5));

        // construct burger order
        Order order = new Order(burger.getId());
        order.setMeatId(1);

        order.setToppingIds(new int[] {
                0,
                1,
                2,
                3
        });

        order.setAdditionIds(new int[] {
                0,
                1
        });


        // order burger
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            shop.order(order);
        });

    }

    @Test
    void testOrderNoMeat() {
        Burger burger = new Burger(0, "Basic Burger", 4, new BigDecimal(5));

        // construct burger order
        Order order = new Order(burger.getId());
        order.setBreadId(1);

        order.setToppingIds(new int[] {
                0,
                1,
                2,
                3
        });

        order.setAdditionIds(new int[] {
                0,
                1
        });


        // order burger
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            shop.order(order);
        });

    }

    @Test
    void testOrderMenuSuccess() {
        Burger burger = new Burger(0, "Basic Burger", 4, new BigDecimal(5));

        // construct burger menu order (one burger with two additions)
        MenuOrder order = new MenuOrder(0, burger.getId(), new int[] {
                0,
                1
        });

        order.setBreadId(1);
        order.setMeatId(1);

        order.setToppingIds(new int[] {
                0,
                1,
                2,
                3
        });


        // order burger
        ProcessedOrder processedOrder = shop.order(order);

        // asserts burger values
        assertEquals(0, processedOrder.getBurger().getId());
        assertEquals("Basic Burger", processedOrder.getBurger().getName());
        assertEquals(4, processedOrder.getBurger().getToppings().length);
        assertEquals(new BigDecimal(5).intValueExact(), processedOrder.getBurger().getPrice().intValueExact());
        assertEquals(1, processedOrder.getBurger().getBread().getId());
        assertEquals(1, processedOrder.getBurger().getMeat().getId());

        // assert burger toppings
        assertEquals(0, processedOrder.getBurger().getToppings()[0].getId());
        assertEquals(1, processedOrder.getBurger().getToppings()[1].getId());
        assertEquals(2, processedOrder.getBurger().getToppings()[2].getId());
        assertEquals(3, processedOrder.getBurger().getToppings()[3].getId());

        // check if ids are still the same for additions
        assertEquals(0, processedOrder.getOrderAdditions().get(0).getId());
        assertEquals(1, processedOrder.getOrderAdditions().get(1).getId());

        // assert burger price
        assertEquals(new BigDecimal("9.75"), processedOrder.getTotalOrderCost());
    }





    /**
     * Inits all the repos present in this application during startup
     */
    private void initRepos() {
        // init repos
        menuOrderRepository = new MenuOrderRepository();
        burgerRepository = new BurgerRepository();
        toppingRepository = new ToppingRepository();
        orderAdditionRepository = new OrderAdditionRepository();
        burgerMeatRepository = new BurgerMeatRepository();
        burgerBreadRepository = new BurgerBreadRepository();
    }

}