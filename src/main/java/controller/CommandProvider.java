package controller;

import java.util.HashMap;
import java.util.Map;
import controller.command.*;

/**
 * Created by Maria on 16.02.2017.
 */
public class CommandProvider {
    private final Map<String, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put("add", new Addition());
        repository.put("search", new Search());
        repository.put("exit", new Exit());
        repository.put("wrongRequest", new WrongRequest());
    }

    /**
     * By title team returns an instance of this command
     *
     * @param name of command which entered
     * @return instances of the class
     */
    Command getCommand(String name) {
        Command command;

        try {
            command = repository.get(name);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get("wrongRequest");
        }
        return command;
    }
}
