package MariosPizza.DataContext.Controller.Contracts;

import MariosPizza.DataContext.DataContext.IEntityContext;

public interface IUserInterface {
    default void show(IEntityContext context) {}
    default void show() {}
}
