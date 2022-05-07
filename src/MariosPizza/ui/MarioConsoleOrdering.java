package MariosPizza.ui;

import MariosPizza.DataContext.Controller.Controller;
import MariosPizza.DataContext.MarioPizzaOrdering;
import MariosPizza.ui.ConsoleInput.ReadInputVerbose;
import MariosPizza.ui.MarioUserInterfaces.*;

public class MarioConsoleOrdering {
    private void injectServices(Controller controller){
        controller.setWelcomeContext(new MarioStartup());
        controller.setRemoveOrderContext(new MarioRemoveOrder());
        controller.setOrderFinishedContext(new MarioFinishOrder());
        controller.setCreateOrderRoutine(new MarioCreateOrder());
        controller.setPizzaMenuContext(new MarioPizzasMenu());
        controller.setOrderMenuPrinter(new MarioOrdersMenu());
        controller.setShutdownRoutine(new MarioShutdown());
        controller.setMenuContext(new MarioContextMenu());
        controller.setMenuReader(new ReadInputVerbose());
    }

    public void launch(){
        var ordering = new MarioPizzaOrdering();
        injectServices(ordering.controller());
        ordering.start();
    }
}
