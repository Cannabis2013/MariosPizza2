package MariosPizza.MarioPizzaOrdering.Controller;

import MariosPizza.MarioPizzaOrdering.Controller.Services.ControllerServices;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public class Controller extends ControllerServices {
    private void decision(IDataContext context) {
      var decision = _readMenuOption.read();
      switch (decision) {
          case 1 -> _createOrder.run(context);
          case 3 -> _printPizzaMenu.run(context);
          case 4 -> _removeOrder.run(context);
          case 5 -> _finishOrder.run(context);
          case 6 -> _shutdown.run(context);
          default -> _printOrdersMenu.run(context);
        }
    }

    public void run(IDataContext context) {
        _startupContext.run();
        _printMenu.print();
        while (true){
            _scrollDevice.disable();
            decision(context);
            _printMenu.print();
        }
    }
}
