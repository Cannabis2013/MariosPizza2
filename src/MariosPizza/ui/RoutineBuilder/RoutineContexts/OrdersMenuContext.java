package MariosPizza.ui.RoutineBuilder.RoutineContexts;

import MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices.IPrintMenuScreen;
import MariosPizza.MarioPizzaOrdering.Controller.RoutineContext.IRoutineContext;
import MariosPizza.MarioPizzaOrdering.DataContext.IDataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.Order;

public class OrdersMenuContext implements IRoutineContext {
    private IPrintMenuScreen<Order> _printOrders;
    public void setMenuPrinter(IPrintMenuScreen<Order> printer){
        _printOrders = printer;
    }

    @Override
    public void run(IDataContext context) {
        var orders = context.orders();
        _printOrders.print(orders);
    }
}
