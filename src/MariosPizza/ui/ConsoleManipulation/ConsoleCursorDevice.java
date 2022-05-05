package MariosPizza.ui.ConsoleManipulation;

import MariosPizza.ui.Contracts.ConsoleUtils.IConsoleCursor;

public class ConsoleCursorDevice implements IConsoleCursor {
    public void hide(){
        System.out.print("\33[?25l");
    }

    public void show(){
        System.out.print("\33[?25h");
    }
}
