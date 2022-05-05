package MariosPizza.MarioPizzaOrdering.DataContext;

import MariosPizza.MarioPizzaOrdering.PizzaContext.Pizza;
import MariosPizza.MarioPizzaOrdering.PizzaContext.PizzaNotFoundException;

import java.util.List;

public interface IPizzasContext {
    boolean isIndexValid(int index);
    List<Pizza> getPizzas();
    List<Pizza> getPizzas(List<Integer> indexes);
    Pizza getPizza(int index) throws PizzaNotFoundException;
}
