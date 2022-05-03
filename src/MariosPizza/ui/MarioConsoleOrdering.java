package MariosPizza.ui;

import MariosPizza.MarioPizzaOrdering.Controller.Controller;
import MariosPizza.MarioPizzaOrdering.MarioPizzaOrdering;
import MariosPizza.ui.RoutineBuilder.ConsoleInput.ReadMenuOption;
import MariosPizza.ui.RoutineBuilder.ConsoleManipulation.DisableConsoleScroll;
import MariosPizza.ui.RoutineBuilder.ConsoleOutput.PrintMenuOperations;
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
        controller.useWelcomeContext(welcomePrinter)
                .useRemoveOrderContext(removeOrder)
                .useOrderFinishedContext(orderFinishedRoutine)
                .useCreateOrderRoutine(createOrderRoutine)
                .usePizzaMenuContext(pizzasMenu)
                .useOrderMenuPrinter(ordersMenu)
                .useShutdownRoutine(shutdown);
    }

    private void useServices(Controller controller){
        controller.useConsoleScrollDevice(new DisableConsoleScroll())
                .useReadMenuOption(new ReadMenuOption())
                .useMenuPrinter(new PrintMenuOperations());
    }

    private void setupUI(MarioPizzaOrdering ordering){
        var controller = ordering.controller();
        setRoutineContexts(controller);
        useServices(controller);
    }

    public void launch(){
        var ordering = new MarioPizzaOrdering();
        setupUI(ordering);
        ordering.start();
    }
}
