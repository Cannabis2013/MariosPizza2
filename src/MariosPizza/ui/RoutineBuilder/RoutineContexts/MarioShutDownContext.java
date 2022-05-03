package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IConsoleCursor;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public class MarioShutDownContext implements IRoutineContext {
    private IConsoleCursor _consoleCursor;
    public void setCursorDevice(IConsoleCursor device) {
        _consoleCursor = device;
    }

    IConsolePrinter _printExitScreen;
    public void setPrinter(IConsolePrinter printer){
        _printExitScreen = printer;
    }

    private IClearScreen _clearConsole;
    public void setClearConsole(IClearScreen clearer){
        _clearConsole = clearer;
    }
    @Override
    public void run(IDataContext context) {
        context.saveOrders();
        _clearConsole.clear();
        _printExitScreen.print();
        _consoleCursor.show();
        System.exit(0);
    }
}
