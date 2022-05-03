package MariosPizza.ui.RoutineBuilder.ConsoleOutput;

import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;

import java.awt.*;

public class PrintBlankScreen implements IConsolePrinter {
    public void print() {
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = dim.height;
        for (var i = 0;i <screenHeight;i++)
          System.out.println();
    }
}
