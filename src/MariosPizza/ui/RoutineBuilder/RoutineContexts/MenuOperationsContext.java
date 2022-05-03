package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IDisableScreenScroll;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;

public class MenuOperationsContext implements IRoutineContext {
    protected IDisableScreenScroll _scrollDevice;
    public void setConsoleScrollDevice(IDisableScreenScroll device) {
        _scrollDevice = device;
    }

    protected IConsolePrinter _printMenu;
    public void setMenuPrinter(IConsolePrinter printer) {
        _printMenu = printer;
    }

    @Override
    public void run() {
        _scrollDevice.disable();
        _printMenu.print();
    }
}
