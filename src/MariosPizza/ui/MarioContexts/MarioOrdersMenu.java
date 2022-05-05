package MariosPizza.ui.MarioContexts;

import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.MarioPizzaOrdering.Controller.Contracts.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.OrdersContext.Order;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;
import MariosPizza.ui.Contracts.IPrintDevice;

public class MarioOrdersMenu implements IRoutineContext {
    private IStringMenuBuilder<Order> _buildOrdersMenu = new BuildOrdersMenu();
    private IPrintDevice _printer = new PrintConsoleOutput();

    @Override
    public void run(IDataContext context) {
        var orders = context.orders();
        var menu = _buildOrdersMenu.build(orders);
        _printer.print(menu);
    }
}
