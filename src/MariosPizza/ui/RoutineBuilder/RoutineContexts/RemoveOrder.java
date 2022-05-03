package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;

public class RemoveOrder implements IRoutineContext {
    private IClearScreen _clearScreen;
    public void setPrintClearScreen(IClearScreen printer){
        _clearScreen = printer;
    }

    private IConsolePrinter _printNoOrders;
    public void setEmptyOrdersPrinter(IConsolePrinter printer){
        _printNoOrders = printer;
    }

    private IReadValueFromUser<Integer> _readOrderID;
    public void setReadOrderID(IReadValueFromUser<Integer> reader){
        _readOrderID = reader;
    }

    private IConsolePrinter _printBadOrderID;
    public void setPrintBadOrder(IConsolePrinter printer){
        _printBadOrderID = printer;
    }

    private IPrintMenuScreen<Order> _printOrderMenu;
    public void setPrintOrderMenu(IPrintMenuScreen<Order> printer){
        _printOrderMenu = printer;
    }

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
        _printOrderMenu.print(orders);
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
