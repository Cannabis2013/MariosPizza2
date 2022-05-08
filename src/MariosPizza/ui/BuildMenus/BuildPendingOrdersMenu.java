package MariosPizza.ui.BuildMenus;

import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.ui.ConsoleOutput.PrintBlankScreen;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.OrdersContext.Order;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BuildPendingOrdersMenu implements IStringMenuBuilder {
    public final String green = "\33[32m";
    public final String blue = "\33[34m";
    public final String red = "\33[31m";
    private final String fastBlink = "\33[6m";
    public final String fReset = "\33[0m";

    private String buildHeader(){

        return green+"\nPENDING ORDERS\n"+fReset;
    }

    private String formatString(String str, Order order){
        if(order.overdue())
            return red + fastBlink + str + fReset;
        else
            return green + str + fReset;
    }

    private List<String> buildMenuEntries(List<Order> orders){
        var strings = new ArrayList<String>();
        for (var i = 0;i <orders.size();i++){
            var order = orders.get(i);
            var orderID = order.orderID;
            var formatter = DateTimeFormatter.ofPattern("HH:mm");
            var orderTime = order.getEstimated().format(formatter);
            var pizzaIndex = order.menuIndex;
            var str = String.format("(%d) Pizza: %-15d  ETA: %s%n",
                    orderID,pizzaIndex,orderTime);
            var formatted = formatString(str,order);
            strings.add(formatted);
        }
        return strings;
    }

    private void lineSpace() {
        PrintBlankScreen lines = new PrintBlankScreen();
        lines.print();
    }

    private String buildMenu(List<Order> orders){
        var header = buildHeader();
        var strings = buildMenuEntries(orders);
        var menu = header;
        menu += strings.stream().reduce("",(s,str) -> str += s);
        return menu;
    }

    private String buildNoOrderMessage(){
        lineSpace();
        var menu = "";
        var emptyOrdersMsg = "-----------------No pending orders at the moment!------------------";
        var lengthOfSpaces = 136 - emptyOrdersMsg.length();
        menu += " ".repeat(lengthOfSpaces/2);
        menu += emptyOrdersMsg;
        menu += " ".repeat(lengthOfSpaces/2);
        return red + fastBlink + menu + fReset + "\n";
    }

    public String build(IEntityContext entityContext){
        var pendingOrders = entityContext.pendingOrders();
        if(pendingOrders.isEmpty())
            return buildNoOrderMessage();
        else
            return buildMenu(pendingOrders);
    }
}
