package MariosPizza.ui.MarioContexts;

import MariosPizza.ui.Contracts.ConsoleUtils.IClearScreen;
import MariosPizza.ui.Contracts.ConsoleUtils.IConsoleCursor;
import MariosPizza.ui.Contracts.ConsoleInput.IWaitForInput;
import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;
import MariosPizza.DataContext.Controller.Contracts.IRoutineContext;
import MariosPizza.ui.ConsoleInput.PromptUserForKey;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleManipulation.ConsoleCursorDevice;
import MariosPizza.ui.ConsoleOutput.PrintWelcomeScreen;

public class MarioStartup implements IRoutineContext {
    private IClearScreen _clearConsole = new ClearConsole();
    private IConsoleCursor _consoleCursor = new ConsoleCursorDevice();
    private IConsolePrinter _printWelcomeScreen = new PrintWelcomeScreen();
    private IWaitForInput _haltDevice = new PromptUserForKey();

    @Override
    public void run() {
        _consoleCursor.hide();
        _clearConsole.clear();
        _printWelcomeScreen.print();
        _haltDevice.halt();
        _clearConsole.clear();
    }
}
