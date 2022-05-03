package MariosPizza.MarioPizzaOrdering.LocalDataContext;

import MariosPizza.MarioPizzaOrdering.DataContext.DataContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.OrdersContext;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext.SerializeOrders;
import MariosPizza.MarioPizzaOrdering.LocalDataContext.PizzaContext.LocalPizzasContext;

public class LocalDataContext extends DataContext {
    public LocalDataContext(){
        setPizzasContext(new LocalPizzasContext());
        setOrdersContext(new OrdersContext(new SerializeOrders()));
    }
}
