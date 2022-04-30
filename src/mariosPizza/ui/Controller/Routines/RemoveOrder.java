package mariosPizza.ui.Controller.Routines;

import mariosPizza.LocalDataContext.Contract.IDataContext;
import mariosPizza.ui.Controller.ControllerServices.ConsoleInput.IReadValueFromUser;

public class RemoveOrder {
    public void remove(IDataContext context, IReadValueFromUser<Integer> inputReader){
        var count = context.orders().size();
        if(count <= 0)
            return;
        var orderID = inputReader.read();
        context.removeOrder(orderID);
    }
}
