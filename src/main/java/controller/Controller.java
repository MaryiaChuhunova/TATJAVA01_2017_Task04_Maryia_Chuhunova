package controller;

import controller.command.Command;

/**
 * Created by Maria on 16.02.2017.
 */
public class Controller {

    private final CommandProvider provider = new CommandProvider();


    public String executeCommand(String request) throws ControllerException {

        String response;
        Command command;

        command = provider.getCommand(request);
        response = command.execute();

        return response;
    }


}
