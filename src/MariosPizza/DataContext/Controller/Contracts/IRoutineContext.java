package MariosPizza.DataContext.Controller.Contracts;

import MariosPizza.DataContext.DataContext.IDataContext;

public interface IRoutineContext {
    default void run(IDataContext context) {}
    default void run() {}
}
