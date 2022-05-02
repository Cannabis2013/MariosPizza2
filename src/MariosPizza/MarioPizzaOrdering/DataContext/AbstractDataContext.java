package MariosPizza.MarioPizzaOrdering.DataContext;

public abstract class AbstractDataContext implements IDataContext{
    protected IOrdersContext ordersContext() {
        return _ordersContext;
    }

    protected IPizzasContext pizzasContext() {
        return _pizzasContext;
    }

    private IOrdersContext _ordersContext;
    private  IPizzasContext _pizzasContext;

    public void setOrdersContext(IOrdersContext ordersContext) {
        _ordersContext = ordersContext;
    }

    public void setPizzasContext(IPizzasContext pizzasContext) {
        _pizzasContext = pizzasContext;
    }
}
