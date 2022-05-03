package MariosPizza.ui.RoutineBuilder.ConsoleManipulation;

import MariosPizza.MarioPizzaOrdering.Controller.Services.Console.IConsoleCursor;

public class ConsoleCursorDevice implements IConsoleCursor {
    public void hide(){
        System.out.print("\33[?25l");
    }

    public void show(){
        System.out.print("\33[?25h");
    }
}
