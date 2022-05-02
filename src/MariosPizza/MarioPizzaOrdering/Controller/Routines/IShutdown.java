package MariosPizza.MarioPizzaOrdering.Controller.Routines;

import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public interface IShutdown {
    void shutdown(IDataContext context);
}
