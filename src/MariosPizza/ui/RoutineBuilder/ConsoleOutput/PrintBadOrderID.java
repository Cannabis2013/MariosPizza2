package MariosPizza.ui.RoutineBuilder.ConsoleOutput;


import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;

public class PrintBadOrderID implements IConsolePrinter {
    @Override
    public void print() {
        var blink = "\33[6m";
        var red = "\33[38:5:88m";
        var reset = "\33[m";
        var text = "No pizza with given orderID!";
        var msg = blink + red + text + reset;
        System.out.println(msg);
    }
}
