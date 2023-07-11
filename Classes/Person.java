package Classes;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String mobileNumber;

    public Person(String name, String surname, LocalDate dateOfBirth, String mobileNumber){
        super();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "\nName : " + this.name + "\nSurname : " + this.surname + "\nDate of Birth : " + this.dateOfBirth + "\nMobile number : " + this.mobileNumber;
    }
}
