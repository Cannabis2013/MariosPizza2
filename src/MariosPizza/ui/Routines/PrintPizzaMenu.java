package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.Controller.Routines.IPrintEntityMenu;
import MariosPizza.ui.ConsoleOutput.PrintPizzas;

public class PrintPizzaMenu extends PrintPizzas implements IPrintEntityMenu {
    @Override
    public void print(IDataContext context){
        var pizzas = context.pizzas();
        print(pizzas);
    }
}
