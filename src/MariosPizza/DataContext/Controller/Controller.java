package MariosPizza.DataContext.Controller;

import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.ui.ConsoleInput.IReadValueFromUser;

public class Controller {
    private IReadValueFromUser<Integer> _readMenuOption;
    public void setMenuReader(IReadValueFromUser<Integer> reader){
        _readMenuOption = reader;
    }

    private IUserInterface _menuUI;
    public void setMenuContext(IUserInterface context) {
        _menuUI = context;
    }

    private IUserInterface _shutdownUI;
    public void setShutdownRoutine(IUserInterface routine){
        _shutdownUI = routine;
    }

    private IUserInterface _startUI;
    public void setWelcomeContext(IUserInterface printer){
        _startUI = printer;
    }

    private IUserInterface _removeOrderUI;
    public void setRemoveOrderContext(IUserInterface routine){
        _removeOrderUI = routine;
    }

    private IUserInterface _createOrderUI;
    public void setCreateOrderRoutine(IUserInterface routine) {
        _createOrderUI = routine;
    }

    private IUserInterface _pizzaMenuUI;
    public void setPizzaMenuContext(IUserInterface printer) {
        _pizzaMenuUI = printer;
    }

    private IUserInterface _printOrdersMenu;
    public void setOrderMenuPrinter(IUserInterface printer){
        _printOrdersMenu = printer;
    }

    private IUserInterface _finishOrderUI;
    public void setOrderFinishedContext(IUserInterface routine){
        _finishOrderUI = routine;
    }

    private void decision(IEntityContext context) {
        var decision = _readMenuOption.read();
        switch (decision) {
            case 1 -> _createOrderUI.show(context);
            case 3 -> _pizzaMenuUI.show(context);
            case 4 -> _removeOrderUI.show(context);
            case 5 -> _finishOrderUI.show(context);
            case 6 -> _shutdownUI.show(context);
            default -> _printOrdersMenu.show(context);
        }
    }

    public void run(IEntityContext context) {
        _startUI.show(context);
        _menuUI.show();
        while (true){
            decision(context);
            _menuUI.show();
        }
    }
}
