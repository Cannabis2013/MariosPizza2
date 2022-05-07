package MariosPizza.ui.ConsoleInput;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class AbstractReadIntegers implements IReadValueFromUser<List<Integer>> {
    private List<Integer> toIntegers(String str){
        var c = Pattern.compile("\\d+");
        var m = c.matcher(str);
        var results = m.results();
        var indexes = results
                .map(r -> Integer.parseInt(r.group())).toList();
        return indexes;
    }

    protected List<Integer> readIntegers(){
        var in = new Scanner(System.in);
        System.out.print("Enter: ");
        var input = in.nextLine();
        var indexes = toIntegers(input);
        return indexes;
    }
}
