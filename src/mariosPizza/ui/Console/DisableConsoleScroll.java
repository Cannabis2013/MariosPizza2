package mariosPizza.ui.Console;

import mariosPizza.ui.Controller.ControllerServices.Console.IDisableScreenScroll;

public class DisableConsoleScroll implements IDisableScreenScroll {
    @Override
    public void disable() {
        System.out.print("\33[3J");
    }
}
