package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.ConsoleOutput.PrintWelcomeScreenHardcoded;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.ConsoleUtils.IConsoleCursor;
import MariosPizza.ui.Contracts.ConsoleInput.IWaitForInput;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.ui.ConsoleInput.PromptUserForKey;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleManipulation.ConsoleCursorDevice;
import MariosPizza.ui.Contracts.IPrintDevice;

public class MarioStartup implements IUserInterface {
    private IClearScreen _clearConsole = new ClearConsole();
    private IConsoleCursor _consoleCursor = new ConsoleCursorDevice();
    private IConsolePrinter _printWelcomeScreen = new PrintWelcomeScreenHardcoded();
    private IPrintDevice _printer = new PrintConsoleOutput();
    private IWaitForInput _haltDevice = new PromptUserForKey();
    private IStringMenuBuilder<Order> _buildOrdersMenu = new BuildOrdersMenu();

    private void printOrdersMenu(IEntityContext context){
        var orders = context.orders();
        var menu = _buildOrdersMenu.build(orders);
        _printer.print(menu);
    }

    @Override
    public void show(IEntityContext context) {
        _consoleCursor.hide();
        _clearConsole.clear();
        _printWelcomeScreen.print();
        _haltDevice.halt();
        _clearConsole.clear();
        printOrdersMenu(context);
    }
}
