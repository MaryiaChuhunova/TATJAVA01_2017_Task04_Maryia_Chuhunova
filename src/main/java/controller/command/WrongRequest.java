package controller.command;

/**
 * Created by Maria on 16.02.2017.
 */
public class WrongRequest implements Command {

    public String execute() {
        return "Wrong request";
    }
}
