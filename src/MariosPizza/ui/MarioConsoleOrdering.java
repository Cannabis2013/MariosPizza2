package MariosPizza.ui;

import MariosPizza.MarioPizzaOrdering.Controller.Controller;
import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Routines.IShutdown;
import MariosPizza.MarioPizzaOrdering.MarioPizzaOrdering;
import MariosPizza.ui.ConsoleManipulation.ClearConsole;
import MariosPizza.ui.ConsoleManipulation.DisableConsoleScroll;
import MariosPizza.ui.ConsoleManipulation.ShowHideConsoleCursor;
import MariosPizza.ui.ConsoleInput.ReadMenuOption;
import MariosPizza.ui.Routines.CreatePizzaOrder;
import MariosPizza.ui.ConsoleInput.ReadOrderDuration;
import MariosPizza.ui.ConsoleInput.ReadPizzaIndex;
import MariosPizza.ui.ConsoleOutput.*;
import MariosPizza.ui.ConsoleInput.ReadOrderID;
import MariosPizza.ui.Routines.*;

public class MarioConsoleOrdering {
    private MarkOrderAsFinished buildOrderFinished(){
        var routine = new MarkOrderAsFinished();
        routine.setReadOrder(new ReadOrderID());
        routine.setPrintOrderMenu(new PrintOrders());
        routine.setPrintBadOrderID(new PrintBadOrderID());
        routine.setConsoleClearer(new ClearConsole());
        return routine;
    }

    private CreatePizzaOrder buildCreateOrder(){
        var routine = new CreatePizzaOrder();
        routine.setPrintClearScreen(new ClearConsole());
        routine.setPrintBadInput(new PrintBadInputFormat());
        routine.setReadIndex(new ReadPizzaIndex());
        routine.setReadDuration(new ReadOrderDuration());
        routine.setPrintClearScreen(new ClearConsole());
        routine.setPrintPizzaMenu(new PrintPizzas());
        routine.setPrintOrderMenu(new PrintOrders());
        return routine;
    }

    private RemoveOrder buildRemoveOrder(){
        var routine = new RemoveOrder();
        routine.setReadOrderID(new ReadOrderID());
        routine.setPrintOrderMenu(new PrintOrders());
        routine.setPrintBadOrder(new PrintBadOrderID());
        routine.setPrintClearScreen(new ClearConsole());
        return routine;
    }

    private IShutdown buildShutDownRoutine(){
        var routine = new ShutdownAndPersist();
        routine.setPrinter(new PrintExitMenu());
        return routine;

    }

    private IConsolePrinter buildWelcomeScreen(){
        var printer = new PrintWelcomeScreen();
        printer.setConsoleClearer(new ClearConsole());
        return printer;
    }


    private void useRoutines(Controller controller){
        var createOrderRoutine = buildCreateOrder();
        var removeOrder = buildRemoveOrder();
        var orderFinishedRoutine = buildOrderFinished();
        var shutdown = buildShutDownRoutine();
        controller.useRemoveOrderRoutine(removeOrder)
                .useOrderFinishedRoutine(orderFinishedRoutine)
                .useCreateOrderRoutine(createOrderRoutine)
                .useOrderMenuPrinter(new PrintOrdersMenu())
                .usePizzaMenuPrinter(new PrintPizzaMenu())
                .useShutdownRoutine(shutdown);
    }

    private void useServices(Controller controller){
        var welcomePrinter = buildWelcomeScreen();
        controller.useConsoleCursorDevice(new ShowHideConsoleCursor())
                .useConsoleScrollDevice(new DisableConsoleScroll())
                .useScreenClearer(new ClearConsole())
                .usePrintIntroRoutine(welcomePrinter)
                .useReadMenuOption(new ReadMenuOption())
                .useMenuPrinter(new PrintMenuOperations());
    }

    private void setupUI(MarioPizzaOrdering ordering){
        var controller = ordering.controller();
        useRoutines(controller);
        useServices(controller);
    }

    public void launch(){
        var ordering = new MarioPizzaOrdering();
        setupUI(ordering);
        ordering.start();
    }
}
