package MariosPizza.DataContext;

import MariosPizza.DataContext.Controller.Controller;
import MariosPizza.DataContext.DataContext.MarioEntityContext;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.DataContext.IOrdersContext;
import MariosPizza.DataContext.OrdersContext.MarioOrdersContext;
import MariosPizza.DataContext.OrdersContext.SerializeOrders;
import MariosPizza.DataContext.PizzaContext.LocalPizzasContext;

public class MarioPizzaOrdering {
    public MarioPizzaOrdering(){
        var dataContext = new MarioEntityContext();
        dataContext.setPizzasContext(new LocalPizzasContext());
        var ordersContext = setupOrdersContext();
        dataContext.setOrdersContext(ordersContext);
        _dataContext = dataContext;
    }

    private IOrdersContext setupOrdersContext(){
        var ordersContext = new MarioOrdersContext();
        var serializer = new SerializeOrders();
        ordersContext.setPersistence(serializer);
        ordersContext.fetchOrders();
        return ordersContext;
    }

    private final IEntityContext _dataContext;

    private final Controller _controller = new Controller();

    public Controller controller() {
        return _controller;
    }

    public void start(){
        _controller.run(_dataContext);
    }
}
