package MariosPizza.MarioPizzaOrdering.Controller.Services.PrinterServices;

import java.util.List;

public interface IPrintMenuScreen<T> {
    void print(List<T> entities);
}
