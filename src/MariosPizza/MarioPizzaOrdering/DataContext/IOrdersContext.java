package MariosPizza.MarioPizzaOrdering.DataContext;

import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.OrderNotFoundException;

import java.util.List;

public interface IOrdersContext {
    List<Order> pendingOrders();

    List<Order> ordersInProgress();

    List<Order> completedOrders();

    List<Order> orders();

    List<Integer> getPizzaIndexesInProgress();

    Order getOrderByID(int id);

    void createOrder(int pizzaIndex, int duration);

    void removeOrder(int orderID);

    void persist();
    boolean orderExists(int orderID);
}
