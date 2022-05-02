package MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext;

import MariosPizza.MarioPizzaOrdering.DataContext.IPizzasContext;

import java.util.List;

public class LocalPizzasContext implements IPizzasContext {
    private final List<Pizza> _pizzas;

    public LocalPizzasContext() {
        _pizzas = new BuildPizzaMenu().build();
    }

    @Override
    public List<Pizza> getPizzas() {return _pizzas;}
    @Override
    public List<Pizza> getPizzas(List<Integer> indexes){
        var pizzas = _pizzas.stream()
                .filter(p -> indexes.contains(p.pizzaIndex()))
                .toList();
        return pizzas;
    }

    @Override
    public Pizza getPizza(int index) throws PizzaNotFoundException {
        var pizza = _pizzas.stream()
                .filter(p -> p.pizzaIndex() == index).findFirst();
        if(pizza.isPresent())
            return pizza.get();
        throw new PizzaNotFoundException(index);
    }
}
