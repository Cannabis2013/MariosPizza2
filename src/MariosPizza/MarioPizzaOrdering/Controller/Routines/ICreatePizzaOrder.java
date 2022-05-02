package MariosPizza.MarioPizzaOrdering.Controller.Routines;

import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public interface ICreatePizzaOrder {
    void create(IDataContext context);
}
