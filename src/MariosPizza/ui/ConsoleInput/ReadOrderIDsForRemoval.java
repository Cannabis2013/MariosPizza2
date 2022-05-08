package MariosPizza.ui.ConsoleInput;

import MariosPizza.ui.ConsoleOutput.PrintConsoleOutput;

import java.util.List;

public class ReadOrderIDsForRemoval extends AbstractReadIntegers {

    public ReadOrderIDsForRemoval(){
        _preText = "Select orders for removal: ";
        _safeMessage = "Sure you want to remove the following orders? ";
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
