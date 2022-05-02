package MariosPizza.ui.ConsoleManipulation;

import MariosPizza.MarioPizzaOrdering.Controller.Console.IDisableScreenScroll;

public class DisableConsoleScroll implements IDisableScreenScroll {
    @Override
    public void disable() {
        System.out.print("\33[3J");
    }
}
