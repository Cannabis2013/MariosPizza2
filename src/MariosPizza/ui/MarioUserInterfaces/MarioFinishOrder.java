package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.OrdersContext.OrderNotFoundException;
import MariosPizza.ui.BuildMenus.BuildPendingOrdersMenu;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.ui.ConsoleInput.ReadOrderIDsForFinishing;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadOrderID;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.IPrintDevice;

import java.util.List;

public class MarioFinishOrder implements IUserInterface {
    private IStringMenuBuilder _printOrderMenu = new BuildPendingOrdersMenu();
    private IClearScreen _clearConsole = new ClearConsole();
    private IReadValueFromUser<List<Integer>> _readOrder = new ReadOrderIDsForFinishing();
    private IConsolePrinter _printBadOrderID = new PrintBadOrderID();
    private IPrintDevice _printer = new PrintConsoleOutput();

    private void printOrderMenu(IEntityContext context){
        var orders = context.pendingOrders();
        var menu = _printOrderMenu.build(context);
        _printer.print(menu);
    }

    private void updateEntityContext(IEntityContext context){
        var orderIDs = _readOrder.read();
        try {
            context.finishOrders(orderIDs);
        } catch (OrderNotFoundException e) {
            _clearConsole.clear();
            _printBadOrderID.print();
        }
    }

    private boolean ordersExists(IEntityContext context){
        var orders = context.orders();
        return orders.size() > 0;
    }

    public void show(IEntityContext context){
        _clearConsole.clear();
        if(ordersExists(context)) {
            printOrderMenu(context);
            updateEntityContext(context);
            _clearConsole.clear();
            printOrderMenu(context);
        }
    }
}
