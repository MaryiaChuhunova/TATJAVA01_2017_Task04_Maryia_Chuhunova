package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Maria on 08.02.2017.
 */
public class ConnectionPool {

    final int MAX_POOL_SIZE = 5;

    BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<Connection>(MAX_POOL_SIZE);
    BlockingQueue<Connection> givenAwayConQueue = new ArrayBlockingQueue<Connection>(MAX_POOL_SIZE);

    private static ConnectionPool instance = new ConnectionPool();

    public ConnectionPool() {
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            connectionQueue.add(createNewConnection());
        }
        System.out.println("Connection Pool is full.");
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    private Connection createNewConnection() {
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PASSWORD);
            System.out.println("Connection: " + connection);
        } catch (SQLException sqle) {
            System.err.println("SQLException: " + sqle);
            connection = null;
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFoundException: " + cnfe);
            connection = null;
        }

        return connection;
    }

    public synchronized Connection takeConnection() {
        Connection connection = null;
        if (connectionQueue.size() > 0) {
            connection = (Connection) connectionQueue.poll();
            givenAwayConQueue.add(connection);
        }
        return connection;
    }

    public synchronized void returnConnection(Connection connection) {
        givenAwayConQueue.remove(connection);
        connectionQueue.add(connection);
    }

}
