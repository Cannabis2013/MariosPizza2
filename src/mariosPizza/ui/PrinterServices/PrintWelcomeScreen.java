package mariosPizza.ui.PrinterServices;

import mariosPizza.ui.Controller.IOServices.IPrintScreen;

import java.io.*;
import java.util.Scanner;

public class PrintWelcomeScreen implements IPrintScreen {
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
        in.nextLine();

    }

    public void print() {
        var msg = readMessage();
        System.out.println(msg);
        halt();
    }
}
