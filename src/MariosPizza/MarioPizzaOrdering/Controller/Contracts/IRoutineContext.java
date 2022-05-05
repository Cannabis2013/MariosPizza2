package MariosPizza.MarioPizzaOrdering.Controller.Contracts;

import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public interface IRoutineContext {
    default void run(IDataContext context) {}
    default void run() {}
}
