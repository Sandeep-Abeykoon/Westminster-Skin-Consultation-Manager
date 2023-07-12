package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

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

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
    }

    public String getMobileNumber(){
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "\nName : " + this.name + "\nSurname : " + this.surname + "\nDate of Birth : " + this.dateOfBirth + "\nMobile number : " + this.mobileNumber;
    }
}
