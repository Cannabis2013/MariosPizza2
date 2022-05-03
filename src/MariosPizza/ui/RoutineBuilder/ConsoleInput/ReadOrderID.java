package MariosPizza.ui.RoutineBuilder.ConsoleInput;

import MariosPizza.MarioPizzaOrdering.Controller.Services.ConsoleInput.IReadValueFromUser;

import java.util.Scanner;

public class ReadOrderID implements IReadValueFromUser<Integer> {
    @Override
    public Integer read() {
        var in = new Scanner(System.in);
        while (true){
            System.out.print("Select order: ");
            var input = in.next();
            int duration;
            try {
                duration = Integer.parseInt(input);
                return duration;
            } catch (NumberFormatException e){
                System.out.println("Bad input");
            }
        }
    }
}
