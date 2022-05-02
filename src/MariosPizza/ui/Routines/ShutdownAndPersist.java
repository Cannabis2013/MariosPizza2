package MariosPizza.ui.Routines;

import MariosPizza.MarioPizzaOrdering.Controller.PrinterServices.IConsolePrinter;
import MariosPizza.MarioPizzaOrdering.Controller.Routines.IShutdown;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;

public class ShutdownAndPersist implements IShutdown {
    IConsolePrinter _printExitScreen;
    public void setPrinter(IConsolePrinter printer){
        _printExitScreen = printer;
    }
    @Override
    public void shutdown(IDataContext context) {
        context.saveOrders();
        _printExitScreen.print();
        System.exit(0);
    }
}
