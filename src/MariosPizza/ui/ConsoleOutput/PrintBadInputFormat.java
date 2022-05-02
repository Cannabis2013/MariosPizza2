package MariosPizza.ui.ConsoleOutput;


import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;

public class PrintBadInputFormat implements IConsolePrinter {
    @Override
    public void print() {
        var blink = "\33[6m";
        var red = "\33[38:5:88m";
        var reset = "\33[m";
        var text = "Not a valid input!";
        var msg = blink + red + text + reset;
        System.out.println(msg);
    }
}
