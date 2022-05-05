package MariosPizza.ui;

import MariosPizza.MarioPizzaOrdering.Controller.Controller;
import MariosPizza.MarioPizzaOrdering.MarioPizzaOrdering;
import MariosPizza.ui.MarioContexts.*;

public class MarioConsoleOrdering {
    private void setRoutineContexts(Controller controller){
        controller.setWelcomeContext(new MarioStartup());
        controller.setRemoveOrderContext(new MarioRemoveOrder());
        controller.setOrderFinishedContext(new MarioFinishOrder());
        controller.setCreateOrderRoutine(new MarioCreateOrder());
        controller.setPizzaMenuContext(new MarioPizzasMenu());
        controller.setOrderMenuPrinter(new MarioOrdersMenu());
        controller.setShutdownRoutine(new MarioShutdown());
        controller.setMenuContext(new MarioContextMenu());
    }

    private void setupUI(MarioPizzaOrdering ordering){
        var controller = ordering.controller();
        setRoutineContexts(controller);
    }

    public void launch(){
        var ordering = new MarioPizzaOrdering();
        setupUI(ordering);
        ordering.start();
    }
}
