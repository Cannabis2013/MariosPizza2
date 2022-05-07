package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.DataContext.OrdersContext.Order;
import MariosPizza.DataContext.PizzaContext.Pizza;
import MariosPizza.ui.BuildMenus.BuildOrdersMenu;
import MariosPizza.ui.BuildMenus.BuildPizzaMenu;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;
import MariosPizza.ui.ConsoleInput.PromptUserForKey;
import MariosPizza.ui.ConsoleInput.ReadIntegersUnsafe;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintBadPizzaIndex;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleInput.IWaitForInput;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.IPrintDevice;

import java.util.List;

public class MarioCreateOrder implements IUserInterface {
    private IWaitForInput _haltDevice = new PromptUserForKey();
    private IClearScreen _clearScreen = new ClearConsole();
    private IStringMenuBuilder<Order> _printOrderMenu = new BuildOrdersMenu();
    private IConsolePrinter _printBadPizzaIndex = new PrintBadPizzaIndex();
    private IReadValueFromUser<List<Integer>> _readPizzaID = new ReadIntegersUnsafe();
    private IStringMenuBuilder<Pizza> _printPizzaMenu = new BuildPizzaMenu();
    private IPrintDevice _printer = new PrintConsoleOutput();

    private void createOrders(List<Integer> pizzaIndexes, IEntityContext context){
        pizzaIndexes.forEach(p -> context.createOrder(p));
    }

    private void printPizzaMenu(IEntityContext context){
        var pizzas = context.pizzas();
        var menu =_printPizzaMenu.build(pizzas);
        _printer.print(menu);
    }

    private List<Integer> readValues(IEntityContext context){
        var pizzaMenuIndexes = _readPizzaID.read();
        var filteredIndexes = pizzaMenuIndexes.stream()
                .filter(i -> {
                    if(!context.isPizzaIndexValid(i)) {
                        _printBadPizzaIndex.print();
                        return false;
                    }
                    return true;
                }).toList();

        return filteredIndexes;
    }

    private void printOrderMenu(IEntityContext context){
        var orders = context.orders();
        var menu = _printOrderMenu.build(orders);
        _printer.print(menu);
    }

    @Override
    public void show(IEntityContext context){
        _clearScreen.clear();
        printPizzaMenu(context);
        var values = readValues(context);
        if(values != null)
            createOrders(values,context);
        _clearScreen.clear();
        printOrderMenu(context);
    }
}