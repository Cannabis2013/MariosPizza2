package mariosPizza.ui.Controller.IOServices;

import mariosPizza.LocalDataContext.pizzaMenu.Pizza;
import mariosPizza.LocalDataContext.pizzaOrders.Order;

public class IOServices {
    protected IPrintScreen _printWelcomeScreen;
    public void setPrintWelcomeScreen(IPrintScreen printWelcomeScreen) {
        _printWelcomeScreen = printWelcomeScreen;
    }

    protected IPrintScreen _printBlank;

    public void setPrintBlank(IPrintScreen printBlank) {
        _printBlank = printBlank;
    }
    protected IPrintScreen _printMenu;
    public void setPrintMenu(IPrintScreen printMenu) {
        _printMenu = printMenu;
    }

    protected IDisableScreenScroll _disableScroll;
    public void setDisableScroll(IDisableScreenScroll disableScroll) {
        _disableScroll = disableScroll;
    }

    protected IClearScreen _clearScreen;
    public void setClearScreen(IClearScreen clearScreen) {
        _clearScreen = clearScreen;
    }

    protected IReadValueFromUser<Integer> _readMenuOption;
    public void setReadMenuOption(IReadValueFromUser<Integer> readMenuOption) {
        _readMenuOption = readMenuOption;
    }

    protected IReadValueFromUser<Integer> _readPizzaIndex;
    public void setReadPizzaIndex(IReadValueFromUser<Integer> readPizzaIndex) {
        _readPizzaIndex = readPizzaIndex;
    }

    protected IReadValueFromUser<Integer> _readPizzaDuration;
    public void setReadPizzaDuration(IReadValueFromUser<Integer> readPizzaDuration) {
        _readPizzaDuration = readPizzaDuration;
    }

    protected IReadValueFromUser<Integer> _readOrderID;
    public void setReadOrderID(IReadValueFromUser<Integer> readOrderID) {
        _readOrderID = readOrderID;
    }

    protected IPrintMenuScreen<Pizza> _printPizzaMenu;
    public void setPrintPizzas(IPrintMenuScreen<Pizza> printPizzaMenu) {
        _printPizzaMenu = printPizzaMenu;
    }

    protected IPrintMenuScreen<Order> _printOrderMenu;
    public void setPrintOrders(IPrintMenuScreen<Order> printOrderMenu) {
        _printOrderMenu = printOrderMenu;
    }

    protected IPrintBadInput _printBadPizzaIndex;

    public void setPrintBadPizzaIndex(IPrintBadInput printBadPizzaIndex) {
        _printBadPizzaIndex = printBadPizzaIndex;
    }

    protected IPrintBadInput _printBadOrderID;
    public void setPrintBadOrderID(IPrintBadInput printBadOrderID) {
        _printBadOrderID = printBadOrderID;
    }

    protected IConsoleCursor _consoleCursor;
    public void setConsoleCursor(IConsoleCursor consoleCursor) {
        _consoleCursor = consoleCursor;
    }
}
