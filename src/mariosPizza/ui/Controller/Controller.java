package mariosPizza.ui.Controller;

import mariosPizza.LocalDataContext.Contract.IDataContext;
import mariosPizza.ui.Controller.ControllerServices.ControllerServices;
import mariosPizza.ui.Controller.Routines.CreatePizzaOrder;
import mariosPizza.ui.Controller.Routines.MarkOrderAsFinished;
import mariosPizza.ui.Controller.Routines.RemoveOrder;

public class Controller extends ControllerServices {
    private IDataContext _dataContext;
    private RemoveOrder _removeOrder = new RemoveOrder();
    private CreatePizzaOrder _createOrder = new CreatePizzaOrder();
    private MarkOrderAsFinished _markFinished = new MarkOrderAsFinished();
    public void setDataContext(IDataContext context) {
        _dataContext = context;
    }

    private void shutDown(){
        _dataContext.saveOrders();
        _clearScreen.clear();
        _consoleCursor.show();
        System.exit(0);
    }

    private void printIntro(){
        _printBlank.print();
        _printWelcomeScreen.print();
        _clearScreen.clear();
        printOrderMenu();
        _printMenu.print();
    }

    public void printPizzaMenu(){
        var pizzas = _dataContext.pizzas();
        _printPizzaMenu.print(pizzas);
    }

    private void printOrderMenu(){
        var orders = _dataContext.orders();
        _printOrderMenu.print(orders);
    }

    public void run() {
        _consoleCursor.hide();
        printIntro();
        while (true){
            _disableScroll.disable();
            decision();
            _printMenu.print();
        }
    }

    public void decision() {
      var decision = _readMenuOption.read();
      _clearScreen.clear();
      switch (decision) {
          case 1 -> {
              printPizzaMenu();
              _createOrder.create(_dataContext,_readPizzaIndex,_readOrderID,_printBadPizzaIndex);
              _clearScreen.clear();
              printOrderMenu();
          }
          case 3 -> printPizzaMenu();
          case 4 -> {
              printOrderMenu();
              _removeOrder.remove(_dataContext,_readOrderID);
          }
          case 5 -> {
              printOrderMenu();
              _markFinished.mark(_dataContext,_readOrderID,_printBadOrderID);
          }
          case 6 -> shutDown();
          default -> printOrderMenu();
        }
    }
}
