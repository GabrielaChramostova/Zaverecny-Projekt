import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Client {
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public Client(String name, String surname, LocalDate dateOfBirth, String phoneNumber) {
        this.setName(name);
        this.setSurname(surname);
        this.setDateOfBirth(dateOfBirth);
        this.setPhoneNumber(phoneNumber);
    }

    /* Date of birth at @Override toString is shown in the "dd.MM.yyyy" format */
    private String formatDate(LocalDate dateToFormat) {
        DateTimeFormatter forOutput = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String output = dateToFormat.format(forOutput);
        return output;
    }

    /* Calculates the age to be shown at @Override toString, so the shown age is always up-to-date */
    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "Name: " + getName() + " " + getSurname() + " || Date of birth: " + formatDate(dateOfBirth) + " || Age: " + calculateAge(dateOfBirth) + " || Telephone number: " + getPhoneNumber();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}