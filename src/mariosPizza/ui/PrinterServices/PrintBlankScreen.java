package mariosPizza.ui.PrinterServices;

import mariosPizza.ui.Controller.ControllerServices.PrinterServices.IPrintScreen;

import java.awt.*;

public class PrintBlankScreen implements IPrintScreen {
    public void print() {
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = dim.height;
        for (var i = 0;i <screenHeight;i++)
          System.out.println();
    }
}
