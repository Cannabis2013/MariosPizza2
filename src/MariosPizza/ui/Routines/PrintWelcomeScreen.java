package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.Controller.Console.IClearScreen;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;

import java.io.*;
import java.util.Scanner;

public class PrintWelcomeScreen implements IConsolePrinter {
    private IClearScreen _clearConsole;
    public void setConsoleClearer(IClearScreen service){
        _clearConsole = service;
    }

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

    private void halt(){
        var in = new Scanner(System.in);
        var blink = "\33[6m";
        var reset = "\33[m";
        var text = "Press a button to continue";
        var msg = blink + text + reset;
        System.out.print(msg);
        var s = in.nextLine();
    }

    public void print() {
        _clearConsole.clear();
        var msg = readMessage();
        System.out.println(msg);
        halt();
        _clearConsole.clear();
    }
}
