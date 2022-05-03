package MariosPizza.ui;

import MariosPizza.MarioPizzaOrdering.Controller.Controller;
import MariosPizza.MarioPizzaOrdering.MarioPizzaOrdering;
import MariosPizza.ui.RoutineBuilder.ConsoleInput.ReadMenuOption;
import MariosPizza.ui.RoutineBuilder.ConsoleManipulation.DisableConsoleScroll;
import MariosPizza.ui.RoutineBuilder.MarioContextBuilder;

public class MarioConsoleOrdering {
    private void setRoutineContexts(Controller controller){
        var builder = new MarioContextBuilder();
        var welcomePrinter = builder.buildWelcomeContext();
        var createOrderRoutine = builder.buildCreateOrder();
        var removeOrder = builder.buildRemoveOrder();
        var orderFinishedRoutine = builder.buildFinishOrderContext();
        var shutdown = builder.buildShutDownRoutine();
        var pizzasMenu = builder.buildPizzasMenuContext();
        var ordersMenu = builder.buildOrdersMenuContext();
        var menuContext = builder.buildMenuContext();
        controller.setWelcomeContext(welcomePrinter);
        controller.setRemoveOrderContext(removeOrder);
        controller.setOrderFinishedContext(orderFinishedRoutine);
        controller.setCreateOrderRoutine(createOrderRoutine);
        controller.setPizzaMenuContext(pizzasMenu);
        controller.setOrderMenuPrinter(ordersMenu);
        controller.setShutdownRoutine(shutdown);
        controller.setMenuContext(menuContext);
    }

    private void setServices(Controller controller){
        controller.setConsoleScrollDevice(new DisableConsoleScroll());
        controller.setReadMenuOption(new ReadMenuOption());
    }

    private void setupUI(MarioPizzaOrdering ordering){
        var controller = ordering.controller();
        setRoutineContexts(controller);
        setServices(controller);
    }

    public void launch(){
        var ordering = new MarioPizzaOrdering();
        setupUI(ordering);
        ordering.start();
    }
}
