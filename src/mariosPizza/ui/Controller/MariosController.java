package mariosPizza.ui.Controller;

import mariosPizza.LocalDataContext.Contract.IDataContext;
import mariosPizza.LocalDataContext.pizzaMenu.PizzaNotFoundException;
import mariosPizza.LocalDataContext.pizzaOrders.OrderNotFoundException;
import mariosPizza.ui.Controller.IOServices.IOServices;

public class MariosController extends IOServices {
    private IDataContext _dataContext;
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

    private void createPizzaOrder() {
        while (true){
            var pizzaIndex = _readPizzaIndex.read();
            var duration = _readPizzaDuration.read();
            try {
                _dataContext.createOrder(pizzaIndex,duration);
                break;
            } catch (PizzaNotFoundException e) {
                _printBadPizzaIndex.print();
            }
        }
    }

    private void removeOrder(){
        var orderID = _readOrderID.read();
        _dataContext.removeOrder(orderID);
    }

    private void markAsFinished(){
        var orderID = _readOrderID.read();
        while (true){
            try {
                _dataContext.finishOrder(orderID);
                break;
            } catch (OrderNotFoundException e) {
                _printBadOrderID.print();
            }
        }
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
              createPizzaOrder();
              _clearScreen.clear();
              printOrderMenu();
          }
          case 3 -> printPizzaMenu();
          case 4 -> {
              printOrderMenu();
              removeOrder();
          }
          case 5 -> {
              printOrderMenu();
              markAsFinished();
          }
          case 6 -> shutDown();
          default -> printOrderMenu();
        }
    }
}
