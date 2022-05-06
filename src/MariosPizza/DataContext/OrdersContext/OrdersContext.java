package MariosPizza.DataContext.OrdersContext;

import MariosPizza.DataContext.DataContext.IOrdersContext;
import MariosPizza.DataContext.DataContext.IPersistence;

import java.util.List;

public class OrdersContext implements IOrdersContext {
    private List<Order> _orders;
    private IPersistence _persistence;
    public void setPersistence(IPersistence persistence){
        _persistence = persistence;
    }

    public void fetchOrders(){
        _orders = _persistence.load();
        if(!_orders.isEmpty())
            Order.setInstanceIndex(_orders.size() + 1);
    }

    @Override
    public List<Order> pendingOrders() {return _orders.stream().filter(Order::isPending).sorted().toList();}
    @Override
    public List<Order> ordersInProgress(){return _orders.stream().filter(Order::isInProgress).toList();}
    @Override
    public List<Order> completedOrders(){return _orders.stream().filter(Order::isDone).toList();}
    @Override
    public List<Order> orders() {return _orders;}

    @Override
    public List<Integer> getPizzaIndexesInProgress(){
        return _orders.stream().filter(Order::isInProgress)
                .map(p -> p.pizzaIndex).toList();
    }

    @Override
    public Order getOrderByID(int id) throws OrderNotFoundException {
        var order = _orders.stream().filter(o -> o.orderID == id).findFirst();
        if(order.isPresent())
            return order.get();
        throw new OrderNotFoundException();
    }

    @Override
    public void createOrder(int pizzaIndex, int duration){
        var order = new Order(pizzaIndex,duration);
        _orders.add(order);
    }

    @Override
    public void removeOrder(int orderID){
        _orders.removeIf(g -> g.orderID == orderID);
    }

    @Override
    public void persist(){
        _persistence.save(_orders);
    }

    @Override
    public boolean orderExists(int orderID) {
        var order = _orders.stream()
                .filter(o -> o.orderID == orderID)
                .findFirst();
        return order.isPresent();
    }
}
