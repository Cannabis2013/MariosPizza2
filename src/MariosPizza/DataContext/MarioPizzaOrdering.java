package MariosPizza.DataContext;

import MariosPizza.DataContext.Controller.Controller;
import MariosPizza.DataContext.DataContext.DataContext;
import MariosPizza.DataContext.DataContext.IDataContext;
import MariosPizza.DataContext.DataContext.IOrdersContext;
import MariosPizza.DataContext.OrdersContext.OrdersContext;
import MariosPizza.DataContext.OrdersContext.SerializeOrders;
import MariosPizza.DataContext.PizzaContext.LocalPizzasContext;

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
