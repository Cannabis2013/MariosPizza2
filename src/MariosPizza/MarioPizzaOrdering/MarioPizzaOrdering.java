package MariosPizza.MarioPizzaOrdering;

import MariosPizza.MarioPizzaOrdering.Controller.Controller;
import MariosPizza.MarioPizzaOrdering.DataContext.DataContext;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.DataContext.IOrdersContext;
import MariosPizza.MarioPizzaOrdering.OrdersContext.OrdersContext;
import MariosPizza.MarioPizzaOrdering.OrdersContext.SerializeOrders;
import MariosPizza.MarioPizzaOrdering.PizzaContext.LocalPizzasContext;

public class MarioPizzaOrdering {
    public MarioPizzaOrdering(){
        var dataContext = new DataContext();
        dataContext.setPizzasContext(new LocalPizzasContext());
        var ordersContext = setupOrdersContext();
        dataContext.setOrdersContext(ordersContext);
        _dataContext = dataContext;
    }

    private IOrdersContext setupOrdersContext(){
        var ordersContext = new OrdersContext();
        var serializer = new SerializeOrders();
        ordersContext.setPersistence(serializer);
        ordersContext.fetchOrders();
        return ordersContext;
    }

    private final IDataContext _dataContext;

    private final Controller _controller = new Controller();

    public Controller controller() {
        return _controller;
    }

    public void start(){
        _controller.run(_dataContext);
    }
}
