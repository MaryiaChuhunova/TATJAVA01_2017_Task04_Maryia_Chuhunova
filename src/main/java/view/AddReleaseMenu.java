package view;

import java.util.*;

/**
 * realization of menu for getting info about release to add
 * Created by Maryia_Chuhunova on 1/31/2017.
 */
public class AddReleaseMenu {

    Scanner sc = new Scanner(System.in);
    String details = "";

    /**
     * gets info about release and sends it to controller layer
     */
    public String getDetails() {
        System.out.println("Enter category of release (Book/Disk/Movie");
        details += sc.nextLine() + "_";
        System.out.println("Enter author");
        details += sc.nextLine() + "_";
        System.out.println("Enter title");
        details += sc.nextLine() + "_";
        System.out.println("Enter release date");
        details += sc.nextLine() + "_";
        System.out.println("Enter addotional info about release (annotation for book/songlist for disk/description for movie");
        details += sc.nextLine() + "_";

        return details;
    }
}
