package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.OrdersContext.MarioOrdersContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.PizzaContext.MarioPizzaContext;
import MariosPizza.DataContext.PizzaContext.Pizza;

import java.util.List;

public class MarioEntityContext implements IEntityContext {
    private IOrdersContext _ordersContext = new MarioOrdersContext();
    private IPizzasContext _pizzasContext = new MarioPizzaContext();

    @Override
    public List<Pizza> pizzas() {
        return _pizzasContext.getPizzas();
    }

    @Override
    public boolean isPizzaIndexValid(int index) {
        return _pizzasContext.isIndexValid(index);
    }

    @Override
    public List<Order> pendingOrders(){
        return _ordersContext.pendingOrders();
    }

    @Override
    public List<Order> ordersInProgress(){
        return _ordersContext.ordersInProgress();
    }

    @Override
    public List<Order> completedOrders(){
        return _ordersContext.completedOrders();
    }

    @Override
    public List<Order> orders(){
        return _ordersContext.orders();
    }

    @Override
    public int createOrder(int pizzaIndex) {
        var pizza = _pizzasContext.getPizza(pizzaIndex);
        var orderID = _ordersContext.createOrder(pizzaIndex, pizza.duration);
        return orderID;
    }

    @Override
    public void startOrder(int orderID){
        _ordersContext.getOrderByID(orderID).setInProgress();
    }

    @Override
    public void finishOrders(List<Integer> orderIDs) {
        _ordersContext.finishOrders(orderIDs);
    }

    @Override
    public List<Pizza> pizzasInProgress(){
        var indexes = _ordersContext.getPizzaIndexesInProgress();
        var pizzas = _pizzasContext.getPizzas(indexes);
        return pizzas;
    }

    @Override
    public void removeOrder(int orderID){
        _ordersContext.remove(orderID);
    }

    public void removeOrders(List<Integer> orderIDs){
        _ordersContext.remove(orderIDs);
    }

    @Override
    public boolean orderExists(int orderID) {
        return _ordersContext.orderExists(orderID);
    }

    @Override
    public void saveOrders(){
        _ordersContext.persist();
    }
}
