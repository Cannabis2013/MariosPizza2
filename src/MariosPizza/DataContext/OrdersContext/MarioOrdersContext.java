package MariosPizza.DataContext.OrdersContext;

import MariosPizza.DataContext.DataContext.IOrdersContext;
import MariosPizza.DataContext.DataContext.IPersistence;

import java.util.List;

public class MarioOrdersContext implements IOrdersContext {
    private List<Order> _orders;
    private IPersistence _persistence = new SerializeOrders();
    public void setPersistence(IPersistence persistence){
        _persistence = persistence;
    }

    public void fetchOrders(){
        _orders = _persistence.load();
        if(!_orders.isEmpty())
            Order.setInstanceIndex(_orders.size() + 1);
    }

    public MarioOrdersContext(){
        fetchOrders();
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
                .map(p -> p.menuIndex).toList();
    }

    @Override
    public Order getOrderByID(int id) throws OrderNotFoundException {
        var order = _orders.stream().filter(o -> o.orderID == id).findFirst();
        if(order.isPresent())
            return order.get();
        throw new OrderNotFoundException();
    }

    @Override
    public void finishOrder(int orderID) {
        var orderOptional = _orders.stream()
                .filter(o -> o.orderID == orderID)
                .findFirst();
        if(!orderOptional.isPresent())
            return;
        var order = orderOptional.get();
        order.setFinished();
    }

    @Override
    public int createOrder(int pizzaIndex, int duration){
        var order = new Order(pizzaIndex,duration);
        _orders.add(order);
        return order.orderID;
    }

    @Override
    public void remove(int orderID){
        _orders.removeIf(g -> g.orderID == orderID);
    }

    @Override
    public void remove(List<Integer> orderIDs) {
        _orders.removeIf(g -> orderIDs.contains(g.orderID));
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
