package MariosPizza.MarioPizzaOrdering.DataContext;

import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.Pizza;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.PizzaNotFoundException;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.OrderNotFoundException;

import java.util.List;

public interface IDataContext {
    List<Pizza> pizzas();

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
