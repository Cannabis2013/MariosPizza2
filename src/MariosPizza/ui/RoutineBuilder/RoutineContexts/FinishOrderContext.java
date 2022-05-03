package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.OrderNotFoundException;

public class FinishOrderContext implements IRoutineContext {
    private IPrintMenuScreen<Order> _printOrderMenu;
    public void setPrintOrderMenu(IPrintMenuScreen<Order> printer){
        _printOrderMenu = printer;
    }

    private IClearScreen _clearConsole;
    public void setConsoleClearer(IClearScreen service){
        _clearConsole = service;
    }

    private IReadValueFromUser<Integer> _readOrder;
    public void setReadOrder(IReadValueFromUser<Integer> readOrder) {
        _readOrder = readOrder;
    }

    private IConsolePrinter _printBadOrderID;
    public void setPrintBadOrderID(IConsolePrinter printBadOrderID) {
        _printBadOrderID = printBadOrderID;
    }

    private void printOrderMenu(IDataContext context){
        var orders = context.orders();
        _printOrderMenu.print(orders);
    }

    private void updateDataContext(IDataContext context){
        var orderID = _readOrder.read();
        try {
            context.finishOrder(orderID);
        } catch (OrderNotFoundException e) {
            _clearConsole.clear();
            _printBadOrderID.print();
        }
    }

    private boolean ordersExists(IDataContext context){
        var orders = context.orders();
        return orders.size() > 0;
    }

    public void run(IDataContext context){
        _clearConsole.clear();
        if(ordersExists(context)) {
            printOrderMenu(context);
            updateDataContext(context);
        }
    }
}
