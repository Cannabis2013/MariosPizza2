package MariosPizza.ui.ConsoleInput;

import java.util.Scanner;

public class ReadPizzaID implements IReadValueFromUser<Integer> {
    @Override
    public Integer read() {
        var in = new Scanner(System.in);
        while (true){
            System.out.print("Pick a pizza from menu: ");
            var input = in.next();
            int pizzaIndex;
            try {
                pizzaIndex = Integer.parseInt(input);
                return pizzaIndex;
            } catch (NumberFormatException e){
                System.out.println("Bad input");
            }
        }
    }
}
