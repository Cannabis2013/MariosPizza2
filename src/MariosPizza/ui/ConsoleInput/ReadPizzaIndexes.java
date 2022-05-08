package MariosPizza.ui.ConsoleInput;

import java.util.List;

public class ReadPizzaIndexes extends AbstractReadIntegers{
    public ReadPizzaIndexes(){
        _preText = "Select pizza from menu by id: ";
    }

    @Override
    public List<Integer> read() {
        return readIntegers();
    }
}
