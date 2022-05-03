package MariosPizza.MarioPizzaOrdering.Controller.Services;

import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IDisableScreenScroll;
import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;

public class ControllerServices {
    protected IDisableScreenScroll _scrollDevice;
    public void setConsoleScrollDevice(IDisableScreenScroll device) {
        _scrollDevice = device;
    }

    protected IRoutineContext _menuContext;
    public void setMenuContext(IRoutineContext context) {
        _menuContext = context;
    }

    protected IReadValueFromUser<Integer> _readMenuOption;
    public void setReadMenuOption(IReadValueFromUser<Integer> reader) {
        _readMenuOption = reader;
    }

    protected IRoutineContext _shutdown;
    public void setShutdownRoutine(IRoutineContext routine){
        _shutdown = routine;
    }

    protected IRoutineContext _startupContext;
    public void setWelcomeContext(IRoutineContext printer){
        _startupContext = printer;
    }

    protected IRoutineContext _removeOrder;
    public void setRemoveOrderContext(IRoutineContext routine){
        _removeOrder = routine;
    }

    protected IRoutineContext _createOrder;
    public void setCreateOrderRoutine(IRoutineContext routine) {
        _createOrder = routine;
    }

    protected IRoutineContext _printPizzaMenu;
    public void setPizzaMenuContext(IRoutineContext printer) {
        _printPizzaMenu = printer;
    }

    protected IRoutineContext _printOrdersMenu;
    public void setOrderMenuPrinter(IRoutineContext printer){
        _printOrdersMenu = printer;
    }

    protected IRoutineContext _finishOrder;
    public void setOrderFinishedContext(IRoutineContext routine){
        _finishOrder = routine;
    }
}
