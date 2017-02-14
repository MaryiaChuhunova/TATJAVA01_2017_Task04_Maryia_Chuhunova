package service;

/**
 * Created by Maria on 13.02.2017.
 */
public class ServiceException extends Exception{

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
