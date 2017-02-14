package view;

import controller.command.ReleaseAdditionController;

import java.util.*;

/**
 * realization of menu for getting info about release to add
 * Created by Maryia_Chuhunova on 1/31/2017.
 */
public class AddReleaseMenu {

    Scanner sc = new Scanner(System.in);
    String release = "";

    /**
     * gets info about release and sends it to controller layer
     */
    public void menu() {
        System.out.println("Enter category of release (Book/Disk/Movie");
        release += sc.nextLine() + "_";
        System.out.println("Enter author");
        release += sc.nextLine() + "_";
        System.out.println("Enter title");
        release += sc.nextLine() + "_";
        System.out.println("Enter release date");
        release += sc.nextLine() + "_";
        System.out.println("Enter addotional info about release (annotation for book/songlist for disk/description for movie");
        release += sc.nextLine() + "_";

        ReleaseAdditionController ra = new ReleaseAdditionController();
        System.out.println(ra.addRelease(release.split("_")));
    }
}
