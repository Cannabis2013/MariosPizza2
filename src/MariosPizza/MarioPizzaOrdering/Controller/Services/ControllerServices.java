package MariosPizza.MarioPizzaOrdering.Controller.Services;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IDisableScreenScroll;
import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;

public class ControllerServices {
    protected IDisableScreenScroll _scrollDevice;
    public ControllerServices useConsoleScrollDevice(IDisableScreenScroll device) {
        _scrollDevice = device;
        return this;
    }

    protected IConsolePrinter _printMenu;
    public ControllerServices useMenuPrinter(IConsolePrinter printer) {
        _printMenu = printer;
        return this;
    }

    protected IReadValueFromUser<Integer> _readMenuOption;
    public ControllerServices useReadMenuOption(IReadValueFromUser<Integer> reader) {
        _readMenuOption = reader;
        return this;
    }

    protected IRoutineContext _shutdown;
    public ControllerServices useShutdownRoutine(IRoutineContext routine){
        _shutdown = routine;
        return this;
    }

    protected IRoutineContext _startupContext;
    public ControllerServices useWelcomeContext(IRoutineContext printer){
        _startupContext = printer;
        return this;
    }

    protected IRoutineContext _removeOrder;
    public ControllerServices useRemoveOrderContext(IRoutineContext routine){
        _removeOrder = routine;
        return this;
    }

    protected IRoutineContext _createOrder;
    public ControllerServices useCreateOrderRoutine(IRoutineContext routine) {
        _createOrder = routine;
        return this;
    }

    protected IRoutineContext _printPizzaMenu;
    public ControllerServices usePizzaMenuContext(IRoutineContext printer) {
        _printPizzaMenu = printer;
        return this;
    }

    protected IRoutineContext _printOrdersMenu;
    public ControllerServices useOrderMenuPrinter(IRoutineContext printer){
        _printOrdersMenu = printer;
        return this;
    }

    protected IRoutineContext _finishOrder;
    public ControllerServices useOrderFinishedContext(IRoutineContext routine){
        _finishOrder = routine;
        return this;
    }
}
