package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.OrdersContext.OrderNotFoundException;
import MariosPizza.ui.ConsoleInput.ReadOrderID;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadOrderID;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;

public class MarioFinishOrder implements IUserInterface {
    private IStringMenuBuilder<Order> _printOrderMenu = new BuildOrdersMenu();
    private IClearScreen _clearConsole = new ClearConsole();
    private IReadValueFromUser<Integer> _readOrder = new ReadOrderID();
    private IConsolePrinter _printBadOrderID = new PrintBadOrderID();

    private void printOrderMenu(IEntityContext context){
        var orders = context.orders();
        _printOrderMenu.build(orders);
    }

    private void updateDataContext(IEntityContext context){
        var orderID = _readOrder.read();
        try {
            context.finishOrder(orderID);
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
            updateDataContext(context);
        }
    }
}
