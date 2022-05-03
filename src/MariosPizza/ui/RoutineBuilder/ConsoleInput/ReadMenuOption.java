package MariosPizza.ui.RoutineBuilder.ConsoleInput;

import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;
import java.util.Scanner;

public class ReadMenuOption implements IReadValueFromUser<Integer> {
    public Integer read(){
        var in = new Scanner(System.in);
        var input = in.nextLine();
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e){
            return -1;
        }
        return option;
    }
}
