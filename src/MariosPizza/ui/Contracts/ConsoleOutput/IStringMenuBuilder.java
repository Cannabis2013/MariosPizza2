package MariosPizza.ui.Contracts.ConsoleOutput;

import java.util.List;

public interface IStringMenuBuilder<T> {
    String build(List<T> entities);
}
