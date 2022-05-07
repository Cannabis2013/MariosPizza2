package MariosPizza.ui.ConsoleInput;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadMultipleIntegers implements IReadValueFromUser<List<Integer>> {
    private List<Integer> toIntegers(String str){
        var c = Pattern.compile("\\d+");
        var m = c.matcher(str);
        var results = m.results();
        var indexes = results
                .map(r -> Integer.parseInt(r.group())).toList();
        return indexes;
    }

    @Override
    public List<Integer> read() {
        var in = new Scanner(System.in);
        var input = in.nextLine();
        var indexes = toIntegers(input);
        return indexes;
    }
}
