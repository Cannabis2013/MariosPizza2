package MariosPizza.ui.ConsoleOutput;

import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;

import java.awt.*;

public class PrintBlankScreen implements IConsolePrinter {
    public void print() {
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = dim.height;
        for (var i = 0;i <screenHeight;i++)
          System.out.println();
    }
}
