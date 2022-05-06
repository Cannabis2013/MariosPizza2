package MariosPizza.ui.MarioContexts;

import MariosPizza.DataContext.Controller.Contracts.IRoutineContext;
import MariosPizza.DataContext.DataContext.IDataContext;
import MariosPizza.DataContext.PizzaContext.Pizza;
import MariosPizza.ui.BuildMenus.BuildPizzaMenu;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.IPrintDevice;

public class MarioPizzasMenu implements IRoutineContext {
    private IStringMenuBuilder<Pizza> _printPizzas = new BuildPizzaMenu();
    private IPrintDevice _printer = new PrintConsoleOutput();
    private IClearScreen _clearScreen = new ClearConsole();
    @Override
    public void run(IDataContext context){
        _clearScreen.clear();
        var pizzas = context.pizzas();
        var menu = _printPizzas.build(pizzas);
        _printer.print(menu);
    }
}
