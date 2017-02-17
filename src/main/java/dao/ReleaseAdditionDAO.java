package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * realization of addition on dao layer
 * Created by Maria on 04.02.2017.
 */
public class ReleaseAdditionDAO {

    String response = null;

    /**
     * writes info about release into file
     * @param releaseDetails info about release
     * @return message about successful/unsuccessful addition
     */
    public String addRelease(String[] releaseDetails) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.takeConnection();

        String query = "INSERT INTO releases(category, author, title, date) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, releaseDetails[0]);
            preparedStatement.setString(2, releaseDetails[1]);
            preparedStatement.setString(3, releaseDetails[2]);
            preparedStatement.setString(4, releaseDetails[3]);
            preparedStatement.executeQuery();
            response = "Release was added successfully";
        } catch (SQLException sqle) {
            response = "Error during adding release";
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage()); //sorry, i know it's not a good idea
            }
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage()); //sorry, i know it's not a good idea
            }
        }

        return response;
    }
}
