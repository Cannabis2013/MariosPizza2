package mariosPizza.ui.CreateOrder;

import mariosPizza.ui.Controller.ControllerServices.ConsoleInput.IReadValueFromUser;
import java.util.Scanner;

public class ReadOrderDuration implements IReadValueFromUser<Integer> {
    @Override
    public Integer read() {
        var in = new Scanner(System.in);
        while (true){
            System.out.print("How many minutes in the making: ");
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
