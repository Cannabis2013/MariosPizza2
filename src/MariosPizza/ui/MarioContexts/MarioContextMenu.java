package MariosPizza.ui.MarioContexts;

import MariosPizza.DataContext.Controller.Contracts.IRoutineContext;
import MariosPizza.ui.Contracts.ConsoleUtils.IDisableScreenScroll;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.ConsoleManipulation.DisableConsoleScroll;
import MariosPizza.ui.ConsoleOutput.PrintMenuOperations;

public class MarioContextMenu implements IRoutineContext {
    protected IDisableScreenScroll _scrollDevice = new DisableConsoleScroll();

    protected IConsolePrinter _printMenu = new PrintMenuOperations();

    @Override
    public void run() {
        _printMenu.print();
        _scrollDevice.disable();
    }
}
