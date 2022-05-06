package MariosPizza.DataContext.DataContext;

import MariosPizza.DataContext.PizzaContext.Pizza;
import MariosPizza.DataContext.PizzaContext.PizzaNotFoundException;

import java.util.List;

public interface IPizzasContext {
    boolean isIndexValid(int index);
    List<Pizza> getPizzas();
    List<Pizza> getPizzas(List<Integer> indexes);
    Pizza getPizza(int index) throws PizzaNotFoundException;
}
