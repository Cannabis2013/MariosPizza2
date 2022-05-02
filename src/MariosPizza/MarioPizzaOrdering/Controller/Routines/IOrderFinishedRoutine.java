package MariosPizza.MarioPizzaOrdering.Controller.Routines;

import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public interface IOrderFinishedRoutine {
    void mark(IDataContext context);
}
