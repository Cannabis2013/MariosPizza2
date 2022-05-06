package MariosPizza.ui.ConsoleInput;

import java.util.Scanner;

public class ReadInputVerbose implements IReadValueFromUser<Integer>{
    @Override
    public Integer read() {
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
