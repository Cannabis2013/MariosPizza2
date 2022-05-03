package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IConsoleCursor;
import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IHaltDevice;
import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;

public class MarioStartupContext implements IRoutineContext {
    private IClearScreen _clearConsole;
    public void setConsoleClearer(IClearScreen service){
        _clearConsole = service;
    }

    private IConsoleCursor _consoleCursor;
    public void setCursorDevice(IConsoleCursor device) {
        _consoleCursor = device;
    }

    private IConsolePrinter _printWelcomeScreen;
    public void setPrinter(IConsolePrinter printer){
        _printWelcomeScreen = printer;
    }

    private IHaltDevice _haltDevice;
    public void setHaltDevice(IHaltDevice device){
        _haltDevice = device;
    }

    @Override
    public void run() {
        _consoleCursor.hide();
        _clearConsole.clear();
        _printWelcomeScreen.print();
        _haltDevice.halt();
        _clearConsole.clear();
    }
}
