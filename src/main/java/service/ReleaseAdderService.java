package service;

import bean.Release;
import dao.ReleaseAdditionDAO;
import parser.ReleaseIntoStringArrayParser;

import java.sql.SQLException;

/**
 * realization of adding command on service layer
 * Created by Maria on 04.02.2017.
 */
public class ReleaseAdderService {

    /**
     * overloaded method, sends parsed into string instance of book to dao layer
     * @param release instance of release
     * @return message about successful/unsuccessful addition
     */
    public String addRelease(Release release) {
        ReleaseIntoStringArrayParser parser = new ReleaseIntoStringArrayParser();
        ReleaseAdditionDAO addition = new ReleaseAdditionDAO();
        return addition.addRelease(parser.parseReleaseIntoStringArray(release));
    }
}
