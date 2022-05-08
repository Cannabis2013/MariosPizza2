package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.ui.BuildMenus.BuildPendingOrdersMenu;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.IPrintDevice;

public class MarioOrdersMenu implements IUserInterface {
    private IStringMenuBuilder _buildOrdersMenu = new BuildPendingOrdersMenu();
    private IClearScreen _clearConsole = new ClearConsole();
    private IPrintDevice _printer = new PrintConsoleOutput();

    @Override
    public void show(IEntityContext context) {
        _clearConsole.clear();
        var orders = context.pendingOrders();
        var menu = _buildOrdersMenu.build(context);
        _printer.print(menu);
    }
}
