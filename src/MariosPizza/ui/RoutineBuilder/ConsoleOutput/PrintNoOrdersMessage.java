package MariosPizza.ui.RoutineBuilder.ConsoleOutput;

import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;

public class PrintNoOrdersMessage implements IConsolePrinter {
    @Override
    public void print() {
        var blink = "\33[6m";
        var red = "\33[38:5:88m";
        var reset = "\33[m";
        var text = "No orders!";
        var msg = blink + red + text + reset;
        var length = text.length();
        var count = 136 - length;
        System.out.print(" ".repeat(count/2));
        System.out.println(msg);
    }
}
