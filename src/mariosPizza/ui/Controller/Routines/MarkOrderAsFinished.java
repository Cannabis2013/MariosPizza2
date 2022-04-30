package mariosPizza.ui.Controller.Routines;

import mariosPizza.LocalDataContext.Contract.IDataContext;
import mariosPizza.LocalDataContext.pizzaOrders.OrderNotFoundException;
import mariosPizza.ui.Controller.ControllerServices.ConsoleInput.IReadValueFromUser;
import mariosPizza.ui.Controller.ControllerServices.PrinterServices.IPrintScreen;

public class MarkOrderAsFinished {
    public void mark(IDataContext context, IReadValueFromUser<Integer> readOrder, IPrintScreen printBadID){
        var orderID = readOrder.read();
        while (true){
            try {
                context.finishOrder(orderID);
                break;
            } catch (OrderNotFoundException e) {
                printBadID.print();
            }
        }
    }
}
