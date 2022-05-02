package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.Controller.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Routines.IRemoveOrder;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;

public class RemoveOrder implements IRemoveOrder {
    private IClearScreen _clearScreen;
    public void setPrintClearScreen(IClearScreen printer){
        _clearScreen = printer;
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

    public void remove(IDataContext context){
        _clearScreen.clear();
        if(!ordersExists(context))
            return;
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
