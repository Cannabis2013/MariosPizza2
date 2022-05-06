package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.OrdersContext.Order;

import java.util.List;

public interface IPersistence {
    void save(List<Order> orders);

    List<Order> load();
}
