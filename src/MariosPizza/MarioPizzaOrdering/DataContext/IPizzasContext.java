package MariosPizza.MarioPizzaOrdering.DataContext;

import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.Pizza;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.PizzaNotFoundException;

import java.util.List;

public interface IPizzasContext {
    List<Pizza> getPizzas();

    List<Pizza> getPizzas(List<Integer> indexes);

    Pizza getPizza(int index) throws PizzaNotFoundException;
}
