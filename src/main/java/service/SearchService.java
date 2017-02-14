package service;

import bean.Release;
import dao.DAOException;
import dao.SearchInFIleDAO;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * realization of search on service layer
 * Created by Maryia_Chuhunova on 2/1/2017.
 */
public class SearchService {

    ArrayList result;

    /**
     * creates instance of book with parameters from dao layer if it's found
     * @param request contains category and tag for search
     * @return instance of found book or null if it's not found
     */
    public ArrayList<Release> searchRelease(String[] request) throws ServiceException {
        SearchInFIleDAO searchInFIle = new SearchInFIleDAO();
        try {
            result = searchInFIle.searchInFile(request);
        } catch (DAOException daoex) {
            throw new ServiceException(daoex.getMessage(), daoex);
        }
        return result;
    }

}
