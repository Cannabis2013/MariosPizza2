package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.Pizza;

public class PizzasMenuContext implements IRoutineContext {
    private IPrintMenuScreen<Pizza> _printPizzas;
    public void setMenuPrinter(IPrintMenuScreen<Pizza> printer){
        _printPizzas = printer;
    }

    @Override
    public void run(IDataContext context){
        var pizzas = context.pizzas();
        _printPizzas.print(pizzas);
    }
}
