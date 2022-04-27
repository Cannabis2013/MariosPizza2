package mariosPizza.ui.Controller.IOServices;

import java.util.List;

public interface IPrintMenuScreen<T> {
    void print(List<T> entities);
}
