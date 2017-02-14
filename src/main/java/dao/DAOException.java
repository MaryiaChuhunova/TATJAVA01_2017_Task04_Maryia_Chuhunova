package dao;

/**
 * Created by Maria on 13.02.2017.
 */
public class DAOException extends Exception {

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
