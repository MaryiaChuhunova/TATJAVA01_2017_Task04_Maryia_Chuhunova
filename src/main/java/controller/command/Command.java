package controller.command;
import controller.ControllerException;
/**
 * Created by Maria on 04.02.2017.
 */
public interface Command  {
    public String execute() throws ControllerException;
}
