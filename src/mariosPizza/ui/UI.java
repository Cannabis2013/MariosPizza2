package mariosPizza.ui;

import mariosPizza.DataContext.DataContext;
import mariosPizza.DataContext.pizzaOrders.OrderNotFoundException;
import java.util.Scanner;

public class UI {

    PrintWelcomeScreen _printWelcome = new PrintWelcomeScreen();
    private final String fReset = "\u001B[0m";
    private final String red = "\u001B[31m";
    private final String blinkingCSI = "\u001B[6m";
    private final Scanner in = new Scanner(System.in);
    private final DataContext dataContext;
    private final PrintOrderMenu printOrderMenu = new PrintOrderMenu();
    private final PrintPizzaMenu printPizzaMenu = new PrintPizzaMenu();
    private final PrintMenuOperations printMenu = new PrintMenuOperations();
    final PrintBlankScreen _printBlankScreen = new PrintBlankScreen();

    public UI(DataContext dataContext) {
        this.dataContext = dataContext;
    }

    public void printMenu() {
        printMenu.print();
    }

    public void createNewOrder() {
        System.out.print("Pick a pizza from menu: ");
        var input = in.next();
        int pizzaIndex;
        try {
            pizzaIndex = Integer.parseInt(input);
        } catch (NumberFormatException e){
            clearScreen();
            printBadInput();
            return;
        }
        System.out.print("How many minutes in the making: ");
        int duration = in.nextInt();
        dataContext.createOrder(pizzaIndex, duration);
        printOrders();
    }

    public void printPizzaMenu() {
        var pizzas = dataContext.pizzas();
        printPizzaMenu.print(pizzas);
    }

   public void removeOrder() {
       var numberOfOrders = dataContext.orders().size();
       if(numberOfOrders <= 0){
           printBlankScreen();
           return;
       }
        printOrders();
        System.out.println(" ");
        System.out.print(red+"Remove order: "+fReset);
        int orderID = in.nextInt();
        dataContext.removeOrder(orderID);
   }

    public void markAsFinished(int orderID){
        var numberOfOrders = dataContext.pendingOrders().size();
        if(numberOfOrders<= 0){
            return;
        }
        try {
            dataContext.finishOrder(orderID);
        } catch (OrderNotFoundException e) {
            return;
        }
    }

    public void clearScreen(){
        System.out.print("\33[2J\33[2H");
        printBlankScreen();
        System.out.flush();
    }

    public void disableScroll(){
        System.out.print("\33[3J");
    }

    public void printOrders() {
        var orders = dataContext.pendingOrders();
        printOrderMenu.print(orders);
    }

    public void printExitMessage() {
        System.out.println(red+"See you!"+fReset);
    }

    public void printBadInput(){
        System.out.println(red+blinkingCSI+"                                                         ----Wrong input----                " + fReset);
    }

    public void printBlankScreen(){
        _printBlankScreen.print();
    }
}
