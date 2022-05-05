package MariosPizza.ui.ConsoleOutput;

import MariosPizza.ui.Contracts.IPrintDevice;

public class PrintConsoleOutput implements IPrintDevice {
    @Override
    public void print(String str) {
        System.out.print(str);
    }
}
