package MariosPizza.ui.ConsoleInput;

import MariosPizza.ui.Contracts.IPrintDevice;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class AbstractReadIntegers implements IReadValueFromUser<List<Integer>> {
    protected String _preText = ": ";
    protected String _safeMessage = "Sure? ";

    private String buildMessage(List<Integer> integers){
        var sb = new StringBuilder();
        sb.append(_safeMessage );
        sb.append("[");
        integers.forEach(i -> {
            var orderID = String.format("%d,",i);
            sb.append(orderID);
        });
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        sb.append(" (Y/n) ");
        return sb.toString();
    }

    protected boolean safetyPrompt(List<Integer> integers, IPrintDevice printer){
        var msg = buildMessage(integers);
        printer.print(msg);
        var in = new Scanner(System.in);
        var input = in.next();
        return !input.equals("n");
    }

    private List<Integer> toIntegers(String str){
        var c = Pattern.compile("\\d+");
        var m = c.matcher(str);
        var results = m.results();
        var indexes = results
                .map(r -> Integer.parseInt(r.group())).toList();
        return indexes;
    }

    protected List<Integer> readIntegers(){
        var reader = new Scanner(System.in);
        System.out.print(_preText);
        var input = reader.nextLine();
        var indexes = toIntegers(input);
        return indexes;
    }
}
