package MariosPizza.ui.BuildMenus;

import MariosPizza.ui.ConsoleOutput.PrintBlankScreen;
import MariosPizza.ui.Contracts.ConsoleOutput.IStringMenuBuilder;
import MariosPizza.DataContext.PizzaContext.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildPizzaMenu implements IStringMenuBuilder<Pizza> {
    public String fReset = "\u001B[0m";
    public String green = "\u001B[32m";
    public String blue = "\u001B[34m";
    public String yellow = "\u001B[33m";

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
        var header = new StringBuilder("\33[33m");
        var label = "PIZZA MENU";
        var lengthOfDots = length - label.length();
        header.append("-".repeat(lengthOfDots));
        int medianIndex;
        if(lengthOfDots % 2 == 0)
            medianIndex = lengthOfDots / 2;
        else
            medianIndex = (lengthOfDots / 2) + 1;
        header.insert(medianIndex,label);
        header.append("\33[m");
        header.append("\n");
        return header.toString();
    }

    public String build(List<Pizza> pizzas){
        var menuEntries = buildEntries(pizzas);
        var totalLength = aggregatedLength(menuEntries);
        var header = buildHeader(totalLength);
        var menu = header;
        menu += menuEntries.stream().reduce("",(s,str) -> str += s);
        return menu;
    }
}
