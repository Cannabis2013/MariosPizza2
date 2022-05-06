package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.PizzaContext.Pizza;
import MariosPizza.DataContext.PizzaContext.PizzaNotFoundException;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.OrdersContext.OrderNotFoundException;
import java.util.List;

public class DataContext extends DataContextServices implements IDataContext {
    @Override
    public List<Pizza> pizzas() {
        return pizzasContext().getPizzas();
    }

    @Override
    public boolean isPizzaIndexValid(int index) {
        return pizzasContext().isIndexValid(index);
    }

    @Override
    public List<Order> pendingOrders(){
        return ordersContext().pendingOrders();
    }

    @Override
    public List<Order> ordersInProgress(){
        return ordersContext().ordersInProgress();
    }

    @Override
    public List<Order> completedOrders(){
        return ordersContext().completedOrders();
    }

    @Override
    public List<Order> orders(){
        return ordersContext().orders();
    }

    @Override
    public void createOrder(int pizzaIndex, int duration) throws PizzaNotFoundException {
        var pizza = pizzasContext().getPizza(pizzaIndex);
        ordersContext().createOrder(pizzaIndex, duration);
    }

    @Override
    public void startOrder(int orderID) throws OrderNotFoundException {
        ordersContext().getOrderByID(orderID).setInProgress();
    }

    @Override
    public void finishOrder(int orderID) {
        ordersContext().getOrderByID(orderID).setFinished();
    }

    @Override
    public List<Pizza> pizzasInProgress(){
        var indexes = ordersContext().getPizzaIndexesInProgress();
        var pizzas = pizzasContext().getPizzas(indexes);
        return pizzas;
    }

    @Override
    public void removeOrder(int orderID){
        ordersContext().removeOrder(orderID);
    }

    @Override
    public boolean orderExists(int orderID) {
        return ordersContext().orderExists(orderID);
    }

    @Override
    public void saveOrders(){
        ordersContext().persist();
    }
}
