package MariosPizza.ui.MarioContexts;

import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.Contracts.IRoutineContext;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.OrdersContext.Order;
import MariosPizza.ui.ConsoleInput.ReadOrderID;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadOrderID;
import MariosPizza.ui.ConsoleOutput.PrintNoOrdersMessage;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;

public class MarioRemoveOrder implements IRoutineContext {
    private IClearScreen _clearScreen = new ClearConsole();
    private IConsolePrinter _printNoOrders = new PrintNoOrdersMessage();
    private IReadValueFromUser<Integer> _readOrderID = new ReadOrderID();

    private IConsolePrinter _printBadOrderID = new PrintBadOrderID();
    private IStringMenuBuilder<Order> _printOrderMenu = new BuildOrdersMenu();

    private int readOrderIDFromUser(IDataContext context){
        var orderID = _readOrderID.read();
        return orderID;
    }

    private void removeOrder(IDataContext context, int orderID){
        var count = context.orders().size();
        context.removeOrder(orderID);
    }

    private void printOrderMenu(IDataContext context){
        var orders = context.orders();
        _printOrderMenu.build(orders);
    }

    private boolean ordersExists(IDataContext context){
        var orders = context.orders();
        return orders.size() != 0;
    }

    public void run(IDataContext context){
        _clearScreen.clear();
        if(!ordersExists(context)) {
            _printNoOrders.print();
            return;
        }
        printOrderMenu(context);
        var orderID = readOrderIDFromUser(context);
        if(!context.orderExists(orderID)){
            _clearScreen.clear();
            _printBadOrderID.print();
            return;
        }
        removeOrder(context,orderID);
        printOrderMenu(context);
    }
}
