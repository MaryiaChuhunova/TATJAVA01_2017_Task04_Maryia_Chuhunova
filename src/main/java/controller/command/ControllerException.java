package controller.command;

/**
 * Created by Maria on 13.02.2017.
 */
public class ControllerException extends Exception {

    public ControllerException(String message, Exception e) {
        super(message, e);
    }
}
