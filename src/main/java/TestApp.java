import graphtutorial.Graph;

import java.io.IOException;
import java.util.*;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("Java Graph Tutorial");
        System.out.println();

        // Load OAuth settings
        final Properties oAuthProperties = new Properties();
        try {
            oAuthProperties.load(TestApp.class.getResourceAsStream("oAuth.properties"));
        } catch ( IOException e) {
            System.out.println("Unable to read OAuth configuration.  Make sure you have a properly formatted oAuth.properties file. See README for details.");
            return;
        }

        final String appId = oAuthProperties.getProperty("app.id");
        final List<String> appScopes = Arrays.asList(oAuthProperties.getProperty("app.scopes").split(","));


        Scanner  input = new Scanner(System.in);

        // Initialize Graph with auth settings
        Graph.initializeGraphAuth(appId, appScopes);
        final String accessToken = Graph.getUserAccessToken();


        int choice = -1;
        while(choice !=0) {
            System.out.println("Please choose one of the following options:");
            System.out.println("0. Exit");
            System.out.println("1. Display access token");
            System.out.println("2. View this week's calendar");
            System.out.println("3. Add an event");

            try {
               choice = input.nextInt();
            } catch(InputMismatchException ex){
                //Skip over non-integer input
            }
            input.nextLine();

            while (choice != 0) {

                // Process user choice
                switch (choice) {
                    case 0:
                        // Exit the program
                        System.out.println("Goodbye...");
                        break;
                    case 1:
                        // Display access token
                        System.out.println("Access token: " + accessToken);
                        break;
                    case 2:
                        // List the calendar
                    case 3:
                        // Create a new event
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
            input.close();
        }
    }
}
