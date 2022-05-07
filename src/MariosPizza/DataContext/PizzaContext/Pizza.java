package MariosPizza.DataContext.PizzaContext;

public class Pizza {
    private static int _instanceIndex = 1;
    private int menuIndex;
    public String name;
    public String topping;
    public int price;
    public int duration;

    public int pizzaIndex() {
        return menuIndex;
    }

    public Pizza(String name, String topping, int price, int duration) {
        this.name = name;
        this.topping = topping;
        this.price = price;
        this.duration = duration;
        menuIndex = _instanceIndex++;
    }
}
