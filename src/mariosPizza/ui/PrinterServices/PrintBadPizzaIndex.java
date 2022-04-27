package mariosPizza.ui.PrinterServices;

import mariosPizza.ui.Controller.IOServices.IPrintBadInput;

public class PrintBadPizzaIndex implements IPrintBadInput {
    @Override
    public void print() {
        var blink = "\33[6m";
        var red = "\33[38:5:88m";
        var reset = "\33[m";
        var text = "Pizza not found!";
        var msg = blink + red + text + reset;
        System.out.println(msg);
    }
}
