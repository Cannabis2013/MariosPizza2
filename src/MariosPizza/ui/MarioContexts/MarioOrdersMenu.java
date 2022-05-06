package MariosPizza.ui.MarioContexts;

import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.Controller.Contracts.IRoutineContext;
import MariosPizza.DataContext.DataContext.IDataContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.IPrintDevice;

public class MarioOrdersMenu implements IRoutineContext {
    private IStringMenuBuilder<Order> _buildOrdersMenu = new BuildOrdersMenu();
    private IClearScreen _clearConsole = new ClearConsole();
    private IPrintDevice _printer = new PrintConsoleOutput();

    @Override
    public void run(IDataContext context) {
        _clearConsole.clear();
        var orders = context.orders();
        var menu = _buildOrdersMenu.build(orders);
        _printer.print(menu);
    }
}
