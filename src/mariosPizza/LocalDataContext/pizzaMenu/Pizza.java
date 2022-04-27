package mariosPizza.LocalDataContext.pizzaMenu;

public class Pizza {
    private static int index = 1;
    private int pizzaIndex;
    public String name;
    public String topping;
    public int price;

    public int pizzaIndex() {
        return pizzaIndex;
    }

    public Pizza(String name, String topping, int price) {
        this.name = name;
        this.topping = topping;
        this.price = price;
        pizzaIndex = index++;
    }
}
