package mariosPizza.LocalDataContext;

import mariosPizza.LocalDataContext.Contract.IDataContext;
import mariosPizza.LocalDataContext.pizzaMenu.Pizza;
import mariosPizza.LocalDataContext.pizzaMenu.PizzaContext;
import mariosPizza.LocalDataContext.pizzaMenu.PizzaNotFoundException;
import mariosPizza.LocalDataContext.pizzaOrders.Order;
import mariosPizza.LocalDataContext.pizzaOrders.OrderNotFoundException;
import mariosPizza.LocalDataContext.pizzaOrders.PizzaOrders;
import java.util.List;

public class LocalDataContext implements IDataContext {
    private PizzaOrders _pizzaOrders = new PizzaOrders();
    private PizzaContext _pizzaContext = new PizzaContext();

    @Override
    public List<Pizza> pizzas() {
        return _pizzaContext.getPizzas();
    }

    @Override
    public List<Order> pendingOrders(){
        return _pizzaOrders.pendingOrders();
    }

    @Override
    public List<Order> ordersInProgress(){
        return _pizzaOrders.ordersInProgress();
    }

    @Override
    public List<Order> completedOrders(){
        return _pizzaOrders.completedOrders();
    }

    @Override
    public List<Order> orders(){
        return _pizzaOrders.orders();
    }

    @Override
    public void createOrder(int pizzaIndex, int duration) throws PizzaNotFoundException {
        var pizza = _pizzaContext.getPizza(pizzaIndex);
        _pizzaOrders.createOrder(pizzaIndex, duration);
    }

    @Override
    public void startOrder(int orderID) throws OrderNotFoundException {
        _pizzaOrders.getOrderByID(orderID).setInProgress();
    }

    @Override
    public void finishOrder(int orderID) throws OrderNotFoundException {
        _pizzaOrders.getOrderByID(orderID).setFinished();
    }

    @Override
    public List<Pizza> pizzasInProgress(){
        var indexes = _pizzaOrders.getPizzaIndexesInProgress();
        var pizzas = _pizzaContext.getPizzas(indexes);
        return pizzas;
    }

    @Override
    public void removeOrder(int orderID){
        _pizzaOrders.removeOrder(orderID);
    }

    @Override
    public void saveOrders(){
        _pizzaOrders.persist();
    }
}
