package controller.command;

import bean.Release;
import parser.ReleaseIntoStringArrayParser;
import service.SearchService;
import service.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * describes instance of search command on controller layer
 * Created by Maria on 05.02.2017.
 */
public class SearchController {

    String[] requestParts = null;

    /**
     * dependently on category given in request sends request to a service layer
     * and gets instance of release
     * @param request contains category and tag for search
     * @return parsed info about release
     */
    public ArrayList<Release> search(String request) throws ControllerException {

        ArrayList<Release> results;

        requestParts = request.split("_");
        SearchService ss = new SearchService();
        ReleaseIntoStringArrayParser parser = new ReleaseIntoStringArrayParser();
        try {
            results = ss.searchRelease(requestParts);
        } catch (ServiceException se) {
            throw new ControllerException(se.getMessage(), se);
        }
        return results;


    }
}
