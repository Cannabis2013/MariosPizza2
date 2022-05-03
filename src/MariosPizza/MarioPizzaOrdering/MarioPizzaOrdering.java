package MariosPizza.MarioPizzaOrdering;

import MariosPizza.MarioPizzaOrdering.Controller.Controller;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.DataContext.DataContext;

public class MarioPizzaOrdering {
    private IDataContext _dataContext = new DataContext();

    public IDataContext dataContext() {
        return _dataContext;
    }

    private final Controller _controller = new Controller();

    public Controller controller() {
        return _controller;
    }

    public void start(){
        _controller.run(_dataContext);
    }
}
