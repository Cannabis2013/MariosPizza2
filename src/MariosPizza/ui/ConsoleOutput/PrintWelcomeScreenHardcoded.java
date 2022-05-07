package MariosPizza.ui.ConsoleOutput;

import MariosPizza.ui.Contracts.ConsoleOutput.IConsolePrinter;

public class PrintWelcomeScreenHardcoded implements IConsolePrinter {
    private String buildMessage(){
        var msg = """
                              __  __            _             _____ _              _
                             |  \\/  |          (_)           |  __ (_)            | |
                             | \\  / | __ _ _ __ _  ___  ___  | |__) | __________ _| |__   __ _ _ __
                             | |\\/| |/ _` | '__| |/ _ \\/ __| |  ___/ |_  /_  / _` | '_ \\ / _` | '__|
                             | |  | | (_| | |  | | (_) \\__ \\ | |   | |/ / / / (_| | |_) | (_| | |
                             |_|  |_|\\__,_|_|  |_|\\___/|___/ |_|   |_/___/___\\__,_|_.__/ \\__,_|_|
                                
                                
                               ____          _           _                _____           _
                              / __ \\        | |         (_)              / ____|         | |
                             | |  | |_ __ __| | ___ _ __ _ _ __   __ _  | (___  _   _ ___| |_ ___ _ __ ___
                             | |  | | '__/ _` |/ _ \\ '__| | '_ \\ / _` |  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\
                             | |__| | | | (_| |  __/ |  | | | | | (_| |  ____) | |_| \\__ \\ ||  __/ | | | | |
                              \\____/|_|  \\__,_|\\___|_|  |_|_| |_|\\__, | |_____/ \\__, |___/\\__\\___|_| |_| |_|
                                                                  __/ |          __/ |
                                                                 |___/          |___/
                """;
        return msg;
    }

    @Override
    public void print() {
        var msg = buildMessage();
        System.out.println(msg);
    }
}
