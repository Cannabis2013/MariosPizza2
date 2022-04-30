package mariosPizza.ui.Controller.Routines;

import mariosPizza.LocalDataContext.Contract.IDataContext;
import mariosPizza.LocalDataContext.pizzaMenu.PizzaNotFoundException;
import mariosPizza.ui.Controller.ControllerServices.ConsoleInput.IReadValueFromUser;
import mariosPizza.ui.Controller.ControllerServices.PrinterServices.IPrintScreen;

public class CreatePizzaOrder {
    public void create(IDataContext context, IReadValueFromUser<Integer> readIndex,
                       IReadValueFromUser<Integer> readDuration,
                       IPrintScreen printBadInput){
        while (true){
            var pizzaIndex = readIndex.read();
            var duration = readDuration.read();
            try {
                context.createOrder(pizzaIndex,duration);
                break;
            } catch (PizzaNotFoundException e) {
                printBadInput.print();
            }
        }
    }
}
