package view;

import controller.Controller;
import controller.ControllerException;

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
        String userResponse = "";
        Controller controller = new Controller();


        while (!userResponse.equals("exit")) {
            System.out.println("Type 'add' if you want to add release. \n Type 'search' if you want to search for release. " +
                    "\n type 'exit' if you want to finish");
            userResponse = sc.nextLine();
            try {
                System.out.println(controller.executeCommand(userResponse));
            } catch (ControllerException ce) {
                System.out.println(ce.getMessage());
            }

        }
    }
}
