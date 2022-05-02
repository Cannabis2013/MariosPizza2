package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.Controller.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.OrderNotFoundException;
import MariosPizza.MarioPizzaOrdering.Controller.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Routines.IOrderFinishedRoutine;

public class MarkOrderAsFinished implements IOrderFinishedRoutine {
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
    public void mark(IDataContext context){
        updateDataContext(context);
    }
}
