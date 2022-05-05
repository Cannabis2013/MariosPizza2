package MariosPizza.ui.ConsoleManipulation;

import MariosPizza.ui.Contracts.ConsoleUtils.IDisableScreenScroll;

public class DisableConsoleScroll implements IDisableScreenScroll {
    @Override
    public void disable() {
        System.out.print("\33[3J");
    }
}
