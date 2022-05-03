package MariosPizza.ui.RoutineBuilder.ConsoleInput;

import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IHaltDevice;

import java.util.Scanner;

public class PromptUserForKey implements IHaltDevice {
    @Override
    public void halt() {
        var in = new Scanner(System.in);
        var blink = "\33[6m";
        var reset = "\33[m";
        var text = "Press a button to continue";
        var msg = blink + text + reset;
        System.out.print(msg);
        var s = in.nextLine();
    }
}
