package MariosPizza.DataContext.Controller.Contracts;

import MariosPizza.DataContext.DataContext.IEntityContext;

public interface IRoutineContext {
    default void run(IEntityContext context) {}
    default void run() {}
}
