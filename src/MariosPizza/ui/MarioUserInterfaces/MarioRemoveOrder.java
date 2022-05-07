package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.ui.ConsoleInput.ReadOrderIDsForRemoval;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadOrderID;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.ConsoleOutput.PrintNoOrdersMessage;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.IPrintDevice;

import java.util.List;

public class MarioRemoveOrder implements IUserInterface {
    private IClearScreen _clearScreen = new ClearConsole();
    private IConsolePrinter _printNoOrders = new PrintNoOrdersMessage();
    private IReadValueFromUser<List<Integer>> _readOrderID = new ReadOrderIDsForRemoval();

    private IConsolePrinter _printBadOrderID = new PrintBadOrderID();
    private IStringMenuBuilder<Order> _printOrderMenu = new BuildOrdersMenu();
    private IPrintDevice _printer = new PrintConsoleOutput();

    private List<Integer> readOrderIDFromUser(IEntityContext context){
        var orderIDs = _readOrderID.read();
        return orderIDs;
    }

    private void printOrderMenu(IEntityContext context){
        var orders = context.orders();
        var menu = _printOrderMenu.build(orders);
        _printer.print(menu);
    }

    private boolean ordersExists(IEntityContext context){
        var orders = context.orders();
        return orders.size() != 0;
    }

    public void show(IEntityContext context){
        _clearScreen.clear();
        if(!ordersExists(context)) {
            _printNoOrders.print();
            return;
        }
        printOrderMenu(context);
        var orderIDs = readOrderIDFromUser(context);
        context.removeOrders(orderIDs);
        printOrderMenu(context);
    }
}
