package MariosPizza.ui.BuildMenus;

import MariosPizza.DataContext.DataContext.IEntityContext;
import MariosPizza.ui.ConsoleOutput.PrintBlankScreen;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.PizzaContext.Pizza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildPizzaMenu implements IStringMenuBuilder {
    public String fReset = "\33[0m";
    public String yellow = "\33[33m";

    private void lineSpace() {
        PrintBlankScreen lines = new PrintBlankScreen();
        lines.print();
    }

    private List<String> buildEntries(List<Pizza> pizzas){
        var entries = new ArrayList<String>();
        for (var i = 0;i < pizzas.size();i++){
            var pizza = pizzas.get(i);
            var name = pizza.name;
            var topping = pizza.topping;
            var price = pizza.price;
            var index = pizza.pizzaIndex();
            var entry = String.format("(%d) %-15s %-75s %3d,-%n", index,name,topping,price);
            entries.add(entry);
        }
        Collections.reverse(entries);
        return entries;
    }

    private int aggregatedLength(List<String> items){
        var aggregatedLength = items.stream()
                .map(String::length)
                .reduce(0,(x,y) -> y = x > y ? x : y);
        return aggregatedLength;
    }

    private String buildHeader(int length){
        var header = new StringBuilder(yellow);
        var label = "PIZZA MENU";
        var lengthOfDots = length - label.length();
        header.append("-".repeat(lengthOfDots));
        int medianIndex;
        if(lengthOfDots % 2 == 0)
            medianIndex = lengthOfDots / 2;
        else
            medianIndex = (lengthOfDots / 2) + 1;
        header.insert(medianIndex,label);
        header.append(fReset);
        header.append("\n");
        return header.toString();
    }

    @Override
    public String build(IEntityContext entityContext){
        var pizzas = entityContext.pizzas();
        var menuEntries = buildEntries(pizzas);
        var totalLength = aggregatedLength(menuEntries);
        var header = buildHeader(totalLength);
        var menu = header;
        menu += menuEntries.stream().reduce("",(s,str) -> str += s);
        return menu;
    }
}
