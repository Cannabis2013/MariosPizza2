package MariosPizza.MarioPizzaOrdering.Controller.Services;

import MariosPizza.MarioPizzaOrdering.Controller.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.Console.IConsoleCursor;
import MariosPizza.MarioPizzaOrdering.Controller.Console.IDisableScreenScroll;
import MariosPizza.MarioPizzaOrdering.Controller.ConsoleInput.IReadValueFromUser;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Routines.*;

public class ControllerServices {
    protected IClearScreen _clearScreen;
    public ControllerServices useScreenClearer(IClearScreen clear){
        _clearScreen = clear;
        return this;
    }

    protected IDisableScreenScroll _scrollDevice;
    public ControllerServices useConsoleScrollDevice(IDisableScreenScroll device) {
        _scrollDevice = device;
        return this;
    }

    protected IConsoleCursor _consoleCursor;
    public ControllerServices useConsoleCursorDevice(IConsoleCursor device) {
        _consoleCursor = device;
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

    protected IShutdown _shutdown;
    public ControllerServices useShutdownRoutine(IShutdown routine){
        _shutdown = routine;
        return this;
    }

    protected IConsolePrinter _printIntro;
    public ControllerServices usePrintIntroRoutine(IConsolePrinter printer){
        _printIntro = printer;
        return this;
    }

    protected IRemoveOrder _removeOrder;
    public ControllerServices useRemoveOrderRoutine(IRemoveOrder routine){
        _removeOrder = routine;
        return this;
    }

    protected ICreatePizzaOrder _createOrder;
    public ControllerServices useCreateOrderRoutine(ICreatePizzaOrder routine) {
        _createOrder = routine;
        return this;
    }

    protected IPrintEntityMenu _printPizzaMenu;
    public ControllerServices usePizzaMenuPrinter(IPrintEntityMenu printer) {
        _printPizzaMenu = printer;
        return this;
    }

    protected IPrintEntityMenu _printOrdersMenu;
    public ControllerServices useOrderMenuPrinter(IPrintEntityMenu printer){
        _printOrdersMenu = printer;
        return this;
    }

    protected IOrderFinishedRoutine _markFinished;
    public ControllerServices useOrderFinishedRoutine(IOrderFinishedRoutine routine){
        _markFinished = routine;
        return this;
    }
}
