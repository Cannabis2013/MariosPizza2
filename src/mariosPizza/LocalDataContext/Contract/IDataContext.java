package mariosPizza.LocalDataContext.Contract;

import mariosPizza.LocalDataContext.pizzaMenu.Pizza;
import mariosPizza.LocalDataContext.pizzaMenu.PizzaNotFoundException;
import mariosPizza.LocalDataContext.pizzaOrders.Order;
import mariosPizza.LocalDataContext.pizzaOrders.OrderNotFoundException;

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

    void saveOrders();
}
