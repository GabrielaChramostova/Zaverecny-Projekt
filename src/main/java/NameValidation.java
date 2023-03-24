import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NameValidation {
    private Scanner input = new Scanner(System.in, "UTF-8");
    private List<String> characters = Arrays.asList("\t", "\\&", ".", "-", ",", "_", " ", "\\?", "\\|", "\\{", "\\}", "!", "\\*", "@", "\\/", "\\;", "\\s+", "(", ")", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    public boolean nameIsValid(String nameToValidate) {
        for (String c : characters)
            if (nameToValidate.contains(c))
                return false;
        return true;
    }

    public boolean nameIsEmpty(String nameToValidate) {
        if (nameToValidate.isEmpty()) {
            System.out.println("Name is required.");
            return true;
        } return false;
    }

    public boolean addClientConfirmation() {
        System.out.println("Name contains special characters, numbers, or more than one name.");
        System.out.println("If you wish to add client anyway, press Y. Otherwise, press any other button.");
        String confirmation = input.nextLine().toLowerCase();
        if (confirmation.equals("y"))
            return true;
        return false;
    }

}
