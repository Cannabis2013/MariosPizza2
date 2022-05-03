package MariosPizza.MarioPizzaOrdering.Controller.RoutineContext;

import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public interface IRoutineContext {
    default void run(IDataContext context) {}
    default void run() {}
}
