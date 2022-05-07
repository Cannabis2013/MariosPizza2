package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.ui.Contracts.ConsoleUtils.IDisableScreenScroll;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.ui.ConsoleManipulation.DisableConsoleScroll;
import MariosPizza.ui.ConsoleOutput.PrintMenuOperations;

public class MarioContextMenu implements IUserInterface {
    IDisableScreenScroll _scrollDevice = new DisableConsoleScroll();
    private IConsolePrinter _printMenu = new PrintMenuOperations();

    @Override
    public void show() {
        _printMenu.print();
        _scrollDevice.disable();
    }
}
