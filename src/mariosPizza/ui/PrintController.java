package mariosPizza.ui;

import mariosPizza.DataContext.DataContext;
import java.util.Scanner;

public class PrintController {
  private final Scanner in = new Scanner(System.in);
  private UI _ui;

  private void shutDown(){
    _ui.printExitMessage();
    System.exit(0);
  }

  public void run(DataContext context) {
    _ui._printBlankScreen.print();
    _ui._printWelcome.print();
    _ui.printMenu();
    while (true) {
      _ui.disableScroll();
      userDecision();
      _ui.printMenu();
    }
  }
  
  public void userDecision() {
    String decision = in.nextLine();
    _ui.clearScreen();
    switch (decision) {
      case "1" -> {
        _ui.printPizzaMenu();
        _ui.createNewOrder();
      }
      case "3" -> _ui.printPizzaMenu();
      case "4" -> {
        _ui.removeOrder();
        _ui.printOrders();
      }
      case "5" -> _ui.markAsFinished();
      case "6" -> shutDown();
      default -> _ui.printOrders();
    }
  }
}
