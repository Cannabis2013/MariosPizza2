package MariosPizza.DataContext;

import MariosPizza.DataContext.Controller.Controller;
import MariosPizza.DataContext.DataContext.MarioEntityContext;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.DataContext.IOrdersContext;
import MariosPizza.DataContext.OrdersContext.MarioOrdersContext;

public class MarioPizzaOrdering {
    private final IEntityContext _entityContext = new MarioEntityContext();

    private final Controller _controller = new Controller();

    public Controller controller() {
        return _controller;
    }

    public void start(){
        _controller.run(_entityContext);
    }
}
