package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.OrdersContext.OrderNotFoundException;
import MariosPizza.DataContext.PizzaContext.Pizza;

import java.util.List;

public interface IEntityContext {
    List<Pizza> pizzas();
    boolean isPizzaIndexValid(int index);
    List<Order> pendingOrders();
    List<Order> ordersInProgress();
    List<Order> completedOrders();
    List<Order> orders();
    int createOrder(int pizzaIndex);
    void startOrder(int orderID) throws OrderNotFoundException;
    void finishOrders(List<Integer> orderIDs);
    List<Pizza> pizzasInProgress();
    void removeOrder(int orderID);
    void removeOrders(List<Integer> orderIDs);
    boolean orderExists(int orderID);
    void saveOrders();
}
