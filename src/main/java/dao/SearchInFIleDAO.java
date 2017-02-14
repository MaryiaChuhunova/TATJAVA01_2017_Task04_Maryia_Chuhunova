package dao;

import bean.Release;
import dao.parser.ResultIntoListParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * realization of search on dao layer
 * Created by Maria on 04.02.2017.
 */
public class SearchInFIleDAO {

    /**
     * searchs in given category line containing given in request tag
     *
     * @param releaseDetails contains category and tag for search
     * @return array with info about found release, or null if release is not found
     */
    public ArrayList<Release> searchInFile(String[] releaseDetails) throws DAOException {

        ArrayList<Release> resultsOfSearch;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.takeConnection();

        String query = "SELECT (*) FROM releases WHERE category = ? AND title = ?";
        ResultSet result;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, releaseDetails[0]);
            preparedStatement.setString(2, releaseDetails[1]);
            result = preparedStatement.executeQuery();
            resultsOfSearch = ResultIntoListParser.parseResultIntoList(result);
        } catch (SQLException e) {
            throw new DAOException("Troubles with connection to source of data", e);
        }

        return resultsOfSearch;
    }
}
