package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.Pizza;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.PizzaNotFoundException;

public class CreateOrderContext implements IRoutineContext {
    private IClearScreen _clearScreen;
    public void setPrintClearScreen(IClearScreen printer){
        _clearScreen = printer;
    }

    private IPrintMenuScreen<Order> _printOrderMenu;
    public void setPrintOrderMenu(IPrintMenuScreen<Order> printer){
        _printOrderMenu = printer;
    }

    private IConsolePrinter _printBadInput;
    public void setPrintBadInput(IConsolePrinter printer){
        _printBadInput = printer;
    }
    private IReadValueFromUser<Integer> _readIndex;
    public void setReadIndex(IReadValueFromUser<Integer> readIndex) {
        _readIndex = readIndex;
    }

    private IReadValueFromUser<Integer> _readDuration;
    public void setReadDuration(IReadValueFromUser<Integer> readDuration) {
        _readDuration = readDuration;
    }

    private IPrintMenuScreen<Pizza> _printPizzaMenu;
    public void setPrintPizzaMenu(IPrintMenuScreen<Pizza> printPizzaMenu) {
        _printPizzaMenu = printPizzaMenu;
    }

    private void createOrder(IDataContext context){
        while (true){
            var pizzaIndex = _readIndex.read();
            var duration = _readDuration.read();
            try {
                context.createOrder(pizzaIndex,duration);
                break;
            } catch (PizzaNotFoundException e) {
                _printBadInput.print();
            }
        }
    }

    private void printPizzaMenu(IDataContext context){
        var pizzas = context.pizzas();
        _printPizzaMenu.print(pizzas);
    }

    private void printOrderMenu(IDataContext context){
        var orders = context.orders();
        _printOrderMenu.print(orders);
    }

    @Override
    public void run(IDataContext context){
        printPizzaMenu(context);
        createOrder(context);
        _clearScreen.clear();
        printOrderMenu(context);
    }
}
