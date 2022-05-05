package MariosPizza.ui.ConsoleOutput;

import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;

public class PrintExitScreen implements IConsolePrinter {


    private String _redCSI = "\33[37m";
    private String _resetCSI = "\33[m";

    @Override
    public void print() {
        System.out.println(_redCSI + "See ya" + _resetCSI);
    }
}
