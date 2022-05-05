package MariosPizza.ui.MarioContexts;

import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.Contracts.IRoutineContext;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.OrdersContext.OrderNotFoundException;
import MariosPizza.ui.ConsoleInput.ReadOrderID;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadOrderID;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;

public class MarioFinishOrder implements IRoutineContext {
    private IStringMenuBuilder<Order> _printOrderMenu = new BuildOrdersMenu();
    private IClearScreen _clearConsole = new ClearConsole();
    private IReadValueFromUser<Integer> _readOrder = new ReadOrderID();
    private IConsolePrinter _printBadOrderID = new PrintBadOrderID();

    private void printOrderMenu(IDataContext context){
        var orders = context.orders();
        _printOrderMenu.build(orders);
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
