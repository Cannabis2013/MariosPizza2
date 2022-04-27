package mariosPizza.ui.Console;

import mariosPizza.ui.Controller.IOServices.IConsoleCursor;

public class ShowHideConsoleCursor implements IConsoleCursor {
    public void hide(){
        System.out.print("\33[?25l");
    }

    public void show(){
        System.out.print("\33[?25h");
    }
}
