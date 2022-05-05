package MariosPizza.MarioPizzaOrdering.DataContext;

import MariosPizza.MarioPizzaOrdering.OrdersContext.Order;

import java.util.List;

public interface IPersistence {
    void save(List<Order> orders);

    List<Order> load();
}
