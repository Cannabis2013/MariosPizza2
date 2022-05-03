package MariosPizza.ui.RoutineBuilder;

import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.ui.RoutineBuilder.ConsoleInput.PromptUserForKey;
import MariosPizza.ui.RoutineBuilder.ConsoleInput.ReadOrderDuration;
import MariosPizza.ui.RoutineBuilder.ConsoleInput.ReadOrderID;
import MariosPizza.ui.RoutineBuilder.ConsoleInput.ReadPizzaIndex;
import MariosPizza.ui.RoutineBuilder.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.RoutineBuilder.ConsoleManipulation.ConsoleCursorDevice;
import MariosPizza.ui.RoutineBuilder.ConsoleManipulation.DisableConsoleScroll;
import MariosPizza.ui.RoutineBuilder.ConsoleOutput.*;
import MariosPizza.ui.RoutineBuilder.RoutineContexts.*;

public class MarioContextBuilder {
    public FinishOrderContext buildFinishOrderContext(){
        var routine = new FinishOrderContext();
        routine.setReadOrder(new ReadOrderID());
        routine.setPrintOrderMenu(new PrintOrders());
        routine.setPrintBadOrderID(new PrintBadOrderID());
        routine.setConsoleClearer(new ClearConsole());
        return routine;
    }

    public CreateOrderContext buildCreateOrder(){
        var routine = new CreateOrderContext();
        routine.setPrintClearScreen(new ClearConsole());
        routine.setPrintBadInput(new PrintBadInputFormat());
        routine.setReadIndex(new ReadPizzaIndex());
        routine.setReadDuration(new ReadOrderDuration());
        routine.setPrintClearScreen(new ClearConsole());
        routine.setPrintPizzaMenu(new PrintPizzas());
        routine.setPrintOrderMenu(new PrintOrders());
        return routine;
    }

    public IRoutineContext buildRemoveOrder(){
        var routine = new RemoveOrder();
        routine.setReadOrderID(new ReadOrderID());
        routine.setPrintOrderMenu(new PrintOrders());
        routine.setPrintBadOrder(new PrintBadOrderID());
        routine.setPrintClearScreen(new ClearConsole());
        routine.setEmptyOrdersPrinter(new PrintNoOrdersMessage());
        return routine;
    }

    public IRoutineContext buildShutDownRoutine(){
        var routine = new MarioShutDownContext();
        routine.setPrinter(new PrintExitScreen());
        routine.setClearConsole(new ClearConsole());
        routine.setCursorDevice(new ConsoleCursorDevice());
        return routine;

    }

    public IRoutineContext buildWelcomeContext(){
        var context = new MarioStartupContext();
        context.setConsoleClearer(new ClearConsole());
        context.setPrinter(new PrintWelcomeScreen());
        context.setHaltDevice(new PromptUserForKey());
        context.setCursorDevice(new ConsoleCursorDevice());
        return context;
    }

    public IRoutineContext buildPizzasMenuContext(){
        var context = new PizzasMenuContext();
        context.setMenuPrinter(new PrintPizzas());
        return context;
    }

    public IRoutineContext buildOrdersMenuContext(){
        var context = new OrdersMenuContext();
        context.setMenuPrinter(new PrintOrders());
        return context;
    }

    public IRoutineContext buildMenuContext(){
        var context = new MenuOperationsContext();
        context.setMenuPrinter(new PrintMenuOperations());
        context.setConsoleScrollDevice(new DisableConsoleScroll());
        return context;
    }
}
