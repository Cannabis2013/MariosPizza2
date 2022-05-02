package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.Controller.Routines.IPrintEntityMenu;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.ui.ConsoleOutput.PrintOrders;

public class PrintOrdersMenu extends PrintOrders implements IPrintEntityMenu {
    @Override
    public void print(IDataContext context) {
        var orders = context.orders();
        print(orders);
    }
}
