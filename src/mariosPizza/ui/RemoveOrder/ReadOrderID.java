package mariosPizza.ui.RemoveOrder;

import mariosPizza.ui.Controller.IOServices.IReadValueFromUser;

import java.util.Scanner;

public class ReadOrderID implements IReadValueFromUser<Integer> {
    @Override
    public Integer read() {
        var in = new Scanner(System.in);
        while (true){
            var input = in.next();
            System.out.print("Select order: ");
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
