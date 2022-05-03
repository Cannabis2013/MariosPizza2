package MariosPizza.ui.RoutineBuilder.ConsoleManipulation;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IDisableScreenScroll;

public class DisableConsoleScroll implements IDisableScreenScroll {
    @Override
    public void disable() {
        System.out.print("\33[3J");
    }
}
