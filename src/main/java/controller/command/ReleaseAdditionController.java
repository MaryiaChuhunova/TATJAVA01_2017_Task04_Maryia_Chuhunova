package controller.command;

import bean.Release;
import service.ReleaseAdderService;

/**
 * describes instance of execution of adding release command on controller level
 * Created by Maria on 04.02.2017.
 */
public class ReleaseAdditionController {

    /**
     * dependently on category of release creates instance of release and sends it to a service layer
     * @param release contains details of release got from view layer
     * @return message about successful of unsuccessful addition
     */
    public String addRelease(String[] release) {
        ReleaseAdderService ra = new ReleaseAdderService();
        String answer = null;

        answer = ra.addRelease(new Release(release[0], release[1], release[2], release[3]));

        return answer;
    }
}
