package MariosPizza.MarioPizzaOrdering.LocalDataContext;

import MariosPizza.MarioPizzaOrdering.DataContext.AbstractDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.LocalOrdersContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.Pizza;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.LocalPizzasContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.PizzaNotFoundException;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.OrderNotFoundException;

import java.util.List;

public class LocalDataContext extends AbstractDataContext {
    public LocalDataContext(){
        setPizzasContext(new LocalPizzasContext());
        setOrdersContext(new LocalOrdersContext());
    }

    @Override
    public List<Pizza> pizzas() {
        return pizzasContext().getPizzas();
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
    public void finishOrder(int orderID) throws OrderNotFoundException {
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
