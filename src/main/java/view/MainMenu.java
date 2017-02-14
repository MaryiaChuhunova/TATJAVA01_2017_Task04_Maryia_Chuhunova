package view;

import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maria on 05.02.2017.
 */
public class MainMenu {

    /**
     * asks user for commands
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddReleaseMenu add = new AddReleaseMenu();
        SearchMenu search = new SearchMenu();
        String response = "";

        while (!response.equals("exit")) {
            System.out.println("Type 'add' if you want to add release. \n Type 'search' if you want to search for release. " +
                    "\n type 'exit' if you want to finish");
            response = sc.nextLine();
            if (response.equals("add")) {
                add.menu();
            } else if (response.equals("search")) {
                search.menu();
            } else if (response.equals("exit")){
                System.out.println("Bye");
            } else {
                System.out.println("Unknown instruction");
            }
        }
    }
}
