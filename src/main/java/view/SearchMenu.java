package view;

import bean.Release;
import controller.command.ControllerException;
import controller.command.SearchController;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * realization of menu for getting info for search
 * Created by Maria on 05.02.2017.
 */
public class SearchMenu {

    Scanner sc = new Scanner(System.in);
    String request = "";

    /**
     * gets info for search and sends it to controller layer
     */
    public void menu() {
        System.out.println("Enter category for search (Book/Disk/Movie");
        request += sc.nextLine() + "_";
        System.out.println("Enter tag for search");
        request += sc.nextLine();

        SearchController sc = new SearchController();
        try {
            ArrayList<Release> resultOfSearch = sc.search(request);
            if (resultOfSearch != null) {
                for (Release release : resultOfSearch) {
                    System.out.println(release.getCategory() + " " + release.getAuthor() + " "
                            + release.getTitle() + " " + release.getReleaseDate());
                }
            } else {
                System.out.println("Nothing found");
            }
        } catch (ControllerException cex) {
            System.out.println(cex.getMessage());
        }
    }
}
