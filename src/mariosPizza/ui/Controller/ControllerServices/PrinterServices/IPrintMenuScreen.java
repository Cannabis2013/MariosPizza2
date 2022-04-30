package mariosPizza.ui.Controller.ControllerServices.PrinterServices;

import java.util.List;

public interface IPrintMenuScreen<T> {
    void print(List<T> entities);
}
