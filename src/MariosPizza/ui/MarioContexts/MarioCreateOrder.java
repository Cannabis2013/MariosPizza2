package MariosPizza.ui.MarioContexts;

import MariosPizza.DataContext.Controller.Contracts.IRoutineContext;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.ConsoleInput.IWaitForInput;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.DataContext.IDataContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.PizzaContext.Pizza;
import MariosPizza.ui.ConsoleInput.PromptUserForKey;
import MariosPizza.ui.ConsoleInput.ReadOrderDuration;
import MariosPizza.ui.ConsoleInput.ReadPizzaID;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadPizzaIndex;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;
import MariosPizza.ui.BuildMenus.BuildPizzaMenu;
import MariosPizza.ui.Contracts.IPrintDevice;

public class MarioCreateOrder implements IRoutineContext {
    private IWaitForInput _haltDevice = new PromptUserForKey();

    private IClearScreen _clearScreen = new ClearConsole();
    private IStringMenuBuilder<Order> _printOrderMenu = new BuildOrdersMenu();
    private IConsolePrinter _printBadPizzaIndex = new PrintBadPizzaIndex();
    private IReadValueFromUser<Integer> _readPizzaID = new ReadPizzaID();
    private IReadValueFromUser<Integer> _readOrderDuration = new ReadOrderDuration();
    private IStringMenuBuilder<Pizza> _printPizzaMenu = new BuildPizzaMenu();
    private IPrintDevice _printer = new PrintConsoleOutput();

    private void createOrder(IDataContext context){
        var pizzaIndex = _readPizzaID.read();
        if(!context.isPizzaIndexValid(pizzaIndex)) {
            _printBadPizzaIndex.print();
            return;
        }
        var duration = _readOrderDuration.read();
        context.createOrder(pizzaIndex,duration);
    }

    private void printPizzaMenu(IDataContext context){
        var pizzas = context.pizzas();
        var menu =_printPizzaMenu.build(pizzas);
        _printer.print(menu);
    }

    private void printOrderMenu(IDataContext context){
        var orders = context.orders();
        _printOrderMenu.build(orders);
    }

    @Override
    public void run(IDataContext context){
        _clearScreen.clear();
        printPizzaMenu(context);
        createOrder(context);
        printOrderMenu(context);
    }
}
