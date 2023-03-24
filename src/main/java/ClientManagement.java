import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ClientManagement {
    private List<Client> clients = new ArrayList<>();
    private Scanner input = new Scanner(System.in, "UTF-8");

    /*
     * Creates Client object that is then added to the clients ArrayList
     * Date of birth is entered, from which age is calculated and shown if client is searched for or client list is shown
     * Date of birth must be entered in the "dd.MM.yyyy" format, otherwise user is asked to re-enter date of birth until the format is correct
     * If name or surname contains any number,special character or more than one name, user is asked if they really want to add the name. 
     */
    public void addClient() {
        NameValidation validation = new NameValidation();
        String clientName;
        String clientSurname;
        LocalDate clientDateOfBirth = null;
        String clientTelephoneNumber = null;
        boolean inputDateIsValid = false;
        boolean telephoneNumberIsValid = false;

        do {
            System.out.println("Enter name");
            clientName = input.nextLine();
        } while ((!validation.nameIsValid(clientName) && (!validation.addClientConfirmation())) || (validation.nameIsEmpty(clientName)));

        do {
            System.out.println("Enter surname");
            clientSurname = input.nextLine();
        } while ((!validation.nameIsValid(clientSurname) && (!validation.addClientConfirmation())) || (validation.nameIsEmpty(clientSurname)));

        System.out.println("Enter date of birth(dd.MM.yyyy)(e.g.,01.01.1990)");
        while (!inputDateIsValid) {
            try {
                String date = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                clientDateOfBirth = LocalDate.parse(date, formatter);
                inputDateIsValid = true;
            } catch (DateTimeException e) {
                inputDateIsValid = false;
                System.out.println("Please enter date of birth again in format (dd.MM.yyyy)(e.g.,01.01.1990)");
            }
        }

        while (!telephoneNumberIsValid) {
            System.out.println("Enter phone number");
            clientTelephoneNumber = input.nextLine().trim();
            telephoneNumberIsValid = !clientTelephoneNumber.isEmpty();
        }

        Client client = new Client(clientName, clientSurname, clientDateOfBirth, clientTelephoneNumber);
        clients.add(client);
    }

    /*
     * If any clients have been added, writes out all of them in alphabetical order. If not, "No clients entered" text is shown.
     */
    public void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients entered");
        } else {
            List<Client> clientsSorted = clients.stream()
                    .sorted(Comparator.comparing(client -> client.getName()))
                    .collect(Collectors.toList());
                     clientsSorted.forEach(System.out::println);
        }
    }

    /* The user can search for clients that have been added. If client list is empty or no match was found, "No clients found" text is shown.
     * The user can search for however many words he wants, the method then checks if client name or surname contains the entered words and writes out all the clients that match. */
    public void searchClient() {
        System.out.println("Enter the name of client you want to search for:");
        String inputToFind = input.nextLine().toLowerCase().trim();
        String[] inputSplit = inputToFind.split("[\\t, ;.?!\\-:@\\[\\](){}_*/]");
        List<Client> foundClients = new ArrayList<>();


        for (Client client : clients) {
            for (String nameToFind : inputSplit) {
                if (client.getName().toLowerCase().contains(nameToFind) || client.getSurname().toLowerCase().contains(nameToFind))  {
                    foundClients.add(client);
                    break;
                }
            }
        }

        if (foundClients.isEmpty()) {
            System.out.println("No clients found");
        } else {
            for (Client clientFound : foundClients) {
                System.out.println(clientFound);
            }
        }
    }

}
