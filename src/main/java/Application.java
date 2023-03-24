import java.util.Scanner;

public class Application {

    public void runApplication() {
        Scanner input = new Scanner(System.in, "UTF-8");
        ClientManagement clientManage = new ClientManagement();
        System.out.println("Welcome to the insurance management app, please choose your next action:");
        System.out.println("1 - Add a new client.");
        System.out.println("2 - List all available clients.");
        System.out.println("3 - Search for a client");
        System.out.println("If you wish to exit the application, press any other key");
        String choice = input.nextLine().trim();


        while (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
            switch (choice) {
                case "1":
                    clientManage.addClient();
                    System.out.println("Next action(Press any other key to exit):");
                    choice = input.nextLine().trim();
                    break;
                case "2":
                    clientManage.listClients();
                    System.out.println("Next action(Press any other key to exit):");
                    choice = input.nextLine().trim();
                    break;
                case "3":
                    clientManage.searchClient();
                    System.out.println("Next action(Press any other key to exit):");
                    choice = input.nextLine().trim();
                    break;
            }
        }
        System.out.println("Thank you for using this application.");
    }


}

