package controller.command;

import bean.Release;
import parser.ReleaseIntoStringArrayParser;
import service.SearchService;
import service.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
import controller.ControllerException;
import view.SearchMenu;


/**
 * describes instance of search command on controller layer
 * Created by Maria on 05.02.2017.
 */
public class Search implements Command{

    /**
     * dependently on category given in request sends request to a service layer
     * and gets instance of release
     *
     * @return parsed info about release
     */
    public String execute() throws ControllerException {

        String[] requestParts;
        ArrayList<Release> results;
        String response = null;
        SearchMenu detailsGettter = new SearchMenu();
        String splitter = "_";

        requestParts = detailsGettter.getDetails().split(splitter);
        SearchService ss = new SearchService();
        ReleaseIntoStringArrayParser parser = new ReleaseIntoStringArrayParser();
        try {
            results = ss.searchRelease(requestParts);
        } catch (ServiceException se) {
            throw new ControllerException(se.getMessage(), se);
        }

        if (results != null) {
            for (Release release : results)
                response += release.toString();
        }

        return response;
    }
}
