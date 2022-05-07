package MariosPizza.ui.ConsoleInput;

import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;
import MariosPizza.ui.Contracts.IPrintDevice;

import java.util.List;
import java.util.Scanner;

public class ReadOrderIDsForRemoval extends AbstractReadIntegers {
    private IPrintDevice _printer = new PrintConsoleOutput();
    private String buildMessage(List<Integer> integers){
        var sb = new StringBuilder();
        sb.append("Remove orders with following ids:");
        sb.append("\n");
        integers.forEach(i -> {
            var orderID = String.format("\t(%d)%n",i);
            sb.append(orderID);
        });
        sb.append("(Y/n)");
        return sb.toString();
    }

    private boolean check(List<Integer> integers){
        var msg = buildMessage(integers);
        _printer.print(msg);
        var in = new Scanner(System.in);
        var input = in.next();
        return !input.equals("n");
    }

    @Override
    public List<Integer> read() {
        var in = new Scanner(System.in);
        List<Integer> integers;
        while (true){
            integers = readIntegers();
            if(check(integers))
               return integers;
        }
    }
}
