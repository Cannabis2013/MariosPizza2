package MariosPizza.ui.RoutineBuilder.ConsoleOutput;

import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IConsolePrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintWelcomeScreen implements IConsolePrinter {

    private String readMessage(){
        try {
            var file = new File("Welcome");
            var sb = new StringBuilder();
            var reader = new Scanner(file);
            while (reader.hasNextLine()){
                sb.append(reader.nextLine());
                sb.append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "Welcome";
        }
    }

    public void print() {
        var msg = readMessage();
        System.out.println(msg);
    }
}
