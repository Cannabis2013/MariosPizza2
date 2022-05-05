package MariosPizza.MarioPizzaOrdering.Controller.ReadKeyboardInput;

public class ReadMenuOption {
    public Integer read(){
        var in = System.console();
        var input = in.readPassword();
        var str = String.valueOf(input);
        int option;
        try {
            option = Integer.parseInt(str);
        } catch (NumberFormatException e){
            return -1;
        }
        return option;
    }
}
