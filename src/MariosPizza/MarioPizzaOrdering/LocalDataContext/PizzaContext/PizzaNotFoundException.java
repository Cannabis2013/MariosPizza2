package MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext;

public class PizzaNotFoundException extends Exception{
    private int index;
    public PizzaNotFoundException(int index){
        this.index = index;
    }

    @Override
    public String getMessage() {
        return String.format("Pizza with index %d not found!", index);
    }
}
