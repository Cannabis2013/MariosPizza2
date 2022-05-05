package MariosPizza.MarioPizzaOrdering.Controller;

import MariosPizza.MarioPizzaOrdering.Controller.Contracts.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.Controller.ReadKeyboardInput.ReadMenuOption;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public class Controller {
    private IRoutineContext _menuContext;
    public void setMenuContext(IRoutineContext context) {
        _menuContext = context;
    }

    private IRoutineContext _shutdown;
    public void setShutdownRoutine(IRoutineContext routine){
        _shutdown = routine;
    }

    private IRoutineContext _startupContext;
    public void setWelcomeContext(IRoutineContext printer){
        _startupContext = printer;
    }

    private IRoutineContext _removeOrder;
    public void setRemoveOrderContext(IRoutineContext routine){
        _removeOrder = routine;
    }

    private IRoutineContext _createOrder;
    public void setCreateOrderRoutine(IRoutineContext routine) {
        _createOrder = routine;
    }

    private IRoutineContext _printPizzaMenu;
    public void setPizzaMenuContext(IRoutineContext printer) {
        _printPizzaMenu = printer;
    }

    private IRoutineContext _printOrdersMenu;
    public void setOrderMenuPrinter(IRoutineContext printer){
        _printOrdersMenu = printer;
    }

    private IRoutineContext _finishOrder;
    public void setOrderFinishedContext(IRoutineContext routine){
        _finishOrder = routine;
    }

    private void decision(IDataContext context) {
        var reader = new ReadMenuOption();
        var decision = reader.read();
        switch (decision) {
            case 1 -> _createOrder.run(context);
            case 3 -> _printPizzaMenu.run(context);
            case 4 -> _removeOrder.run(context);
            case 5 -> _finishOrder.run(context);
            case 6 -> _shutdown.run(context);
            default -> _printOrdersMenu.run(context);
        }
    }

    public void run(IDataContext context) {
        _startupContext.run();
        _menuContext.run();
        while (true){
            decision(context);
            _menuContext.run();
        }
    }
}
