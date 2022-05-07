package MariosPizza.ui.MarioUserInterfaces;

import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.ConsoleUtils.IConsoleCursor;
import MariosPizza.DataContext.Controller.Contracts.IUserInterface;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleManipulation.ConsoleCursorDevice;
import MariosPizza.ui.ConsoleOutput.PrintExitScreen;

public class MarioShutdown implements IUserInterface {
    private IConsoleCursor _consoleCursor = new ConsoleCursorDevice();
    private IClearScreen _clearConsole = new ClearConsole();
    IConsolePrinter _printExitScreen = new PrintExitScreen();
    @Override
    public void show(IEntityContext context) {
        context.saveOrders();
        _clearConsole.clear();
        _printExitScreen.print();
        _consoleCursor.show();
        System.exit(0);
    }
}
