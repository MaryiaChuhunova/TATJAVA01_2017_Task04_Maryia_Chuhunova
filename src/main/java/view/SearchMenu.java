package view;

import java.util.Scanner;

/**
 * realization of menu for getting info for search
 * Created by Maria on 05.02.2017.
 */
public class SearchMenu {

    Scanner sc = new Scanner(System.in);
    String details = "";
    String splitter = "_";

    /**
     * gets info for search and sends it to controller layer
     */
    public String getDetails() {
        System.out.println("Enter category for search (Book/Disk/Movie");
        details += sc.nextLine() + splitter;
        System.out.println("Enter tag for search");
        details += sc.nextLine();

        return details;
    }
}
