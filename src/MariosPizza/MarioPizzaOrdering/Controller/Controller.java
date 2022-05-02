package MariosPizza.MarioPizzaOrdering.Controller;

import MariosPizza.MarioPizzaOrdering.Controller.Services.ControllerServices;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public class Controller extends ControllerServices {
    private void decision(IDataContext context) {
      var decision = _readMenuOption.read();
      switch (decision) {
          case 1 -> _createOrder.create(context);
          case 3 -> _printPizzaMenu.print(context);
          case 4 -> _removeOrder.remove(context);
          case 5 -> _markFinished.mark(context);
          case 6 -> _shutdown.shutdown(context);
          default -> _printOrdersMenu.print(context);
        }
    }

    public void run(IDataContext context) {
        _consoleCursor.hide();
        _printIntro.print();
        _printMenu.print();
        while (true){
            _scrollDevice.disable();
            decision(context);
            _printMenu.print();
        }
    }
}
