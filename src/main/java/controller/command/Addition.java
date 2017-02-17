package controller.command;

import bean.Release;
import service.ReleaseAdderService;
import controller.ControllerException;
import view.AddReleaseMenu;

/**
 * describes instance of execution of adding release command on controller level
 * Created by Maria on 04.02.2017.
 */
public class Addition implements Command{

    /**
     * dependently on category of release creates instance of release and sends it to a service layer
     * @return message about successful of unsuccessful addition
     */
    public String execute() throws ControllerException {
        ReleaseAdderService ra = new ReleaseAdderService();
        String response;
        String splitter = "_";
        AddReleaseMenu detailsGetter = new AddReleaseMenu();

        String[] releaseDetails = detailsGetter.getDetails().split(splitter);
        response = ra.addRelease(new Release(releaseDetails[0], releaseDetails[1], releaseDetails[2], releaseDetails[3]));

        return response;
    }
}
