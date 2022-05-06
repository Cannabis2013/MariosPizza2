package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.PizzaContext.Pizza;
import MariosPizza.DataContext.PizzaContext.PizzaNotFoundException;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.OrdersContext.OrderNotFoundException;

import java.util.List;

public interface IDataContext {
    List<Pizza> pizzas();

    boolean isPizzaIndexValid(int index);

    List<Order> pendingOrders();

    List<Order> ordersInProgress();

    List<Order> completedOrders();

    List<Order> orders();

    void createOrder(int pizzaIndex, int duration) throws PizzaNotFoundException;

    void startOrder(int orderID) throws OrderNotFoundException;

    void finishOrder(int orderID) throws OrderNotFoundException;

    List<Pizza> pizzasInProgress();

    void removeOrder(int orderID);
    boolean orderExists(int orderID);

    void saveOrders();
}
