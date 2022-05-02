package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;

public class PrintExitMenu implements IConsolePrinter {
    private String _redCSI = "\33[37m";
    private String _resetCSI = "\33[m";

    @Override
    public void print() {
        System.out.println(_redCSI + "See ya" + _resetCSI);
    }
}
