package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.OrdersContext.Order;

import java.util.List;

public interface IOrdersContext {
    List<Order> pendingOrders();

    List<Order> ordersInProgress();

    List<Order> completedOrders();

    List<Order> orders();

    List<Integer> getPizzaIndexesInProgress();

    Order getOrderByID(int id);

    void createOrder(int pizzaIndex, int duration);

    void remove(int orderID);
    void remove(List<Integer> orderIDs);

    void persist();
    boolean orderExists(int orderID);
}
