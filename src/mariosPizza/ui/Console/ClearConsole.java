package mariosPizza.ui.Console;

import mariosPizza.ui.Controller.IOServices.IClearScreen;

import java.awt.*;

public class ClearConsole implements IClearScreen {
    private void printBlank(){
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = dim.height;
        for (var i = 0;i <screenHeight;i++)
            System.out.println();
    }
    @Override
    public void clear() {
        System.out.print("\33[2J\33[2H");
        printBlank();
        System.out.flush();
    }
}
