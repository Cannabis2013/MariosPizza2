package MariosPizza.ui.ConsoleInput;

import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;

import java.util.List;

public class ReadOrderIDsForFinishing extends AbstractReadIntegers{
    public ReadOrderIDsForFinishing(){
        _preText = "Select orderIDs: ";
        _safeMessage = "Sure they are finished? Maybe you missed some tomatoes or garlic on one of the pizzas? :-D ";
    }

    @Override
    public List<Integer> read() {
        List<Integer> integers;
        while (true){
            integers = readIntegers();
            if(safetyPrompt(integers,new PrintConsoleOutput()))
                return integers;
        }
    }
}
