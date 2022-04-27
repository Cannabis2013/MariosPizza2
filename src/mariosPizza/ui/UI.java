package mariosPizza.ui;

import mariosPizza.LocalDataContext.LocalDataContext;
import mariosPizza.ui.Console.ShowHideConsoleCursor;
import mariosPizza.ui.Controller.MariosController;
import mariosPizza.ui.CreateOrder.ReadOrderDuration;
import mariosPizza.ui.CreateOrder.ReadPizzaIndex;
import mariosPizza.ui.Console.ClearConsole;
import mariosPizza.ui.Console.DisableConsoleScroll;
import mariosPizza.ui.IOServices.ReadMenuOption;
import mariosPizza.ui.PrinterServices.*;
import mariosPizza.ui.RemoveOrder.ReadOrderID;

public class UI {
    MariosController _marios;
    public UI(){
        _marios = new MariosController();
        _marios.setDataContext(new LocalDataContext());
        _marios.setPrintPizzas(new PrintPizzaMenu());
        _marios.setPrintOrders(new PrintOrderMenu());
        _marios.setClearScreen(new ClearConsole());
        _marios.setPrintBlank(new PrintBlankScreen());
        _marios.setPrintMenu(new PrintMenuOperations());
        _marios.setReadOrderID(new ReadOrderID());
        _marios.setReadPizzaIndex(new ReadPizzaIndex());
        _marios.setReadPizzaDuration(new ReadOrderDuration());
        _marios.setPrintWelcomeScreen(new PrintWelcomeScreen());
        _marios.setDisableScroll(new DisableConsoleScroll());
        _marios.setReadMenuOption(new ReadMenuOption());
        _marios.setPrintBadPizzaIndex(new PrintBadPizzaIndex());
        _marios.setConsoleCursor(new ShowHideConsoleCursor());
    }

    public void run(){
        _marios.run();
    }
}
