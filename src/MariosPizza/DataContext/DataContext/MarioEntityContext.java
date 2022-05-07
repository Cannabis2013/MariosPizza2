package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.OrdersContext.OrderNotFoundException;
import MariosPizza.DataContext.PizzaContext.Pizza;

import java.util.List;

public class MarioEntityContext extends EntityContextServices implements IEntityContext {
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
    public void createOrder(int pizzaIndex) {
        var pizza = pizzasContext().getPizza(pizzaIndex);
        ordersContext().createOrder(pizzaIndex, pizza.duration);
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
        ordersContext().remove(orderID);
    }

    public void removeOrders(List<Integer> orderIDs){
        ordersContext().remove(orderIDs);
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
