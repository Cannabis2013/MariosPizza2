package MariosPizza.ui.BuildMenus;

import MariosPizza.ui.ConsoleOutput.PrintBlankScreen;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.OrdersContext.Order;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BuildOrdersMenu implements IStringMenuBuilder<Order> {
    public String fReset = "\u001B[0m";
    public String green = "\u001B[32m";
    public String blue = "\u001B[34m";
    public String red = "\u001B[31m";
    private final String blinkingCSI = "\u001B[6m";

    private String buildHeader(){

        return green+"\nPENDING ORDERS\n"+fReset;
    }

    private String formatString(String str, Order order){
        if(order.overdue())
            return red + blinkingCSI + str + fReset;
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
        return red + blinkingCSI + menu + fReset + "\n";
    }

    public String build(List<Order> orders){
        if(orders.isEmpty())
            return buildNoOrderMessage();
        else
            return buildMenu(orders);
    }
}
