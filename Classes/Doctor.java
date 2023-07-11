package Classes;

import java.time.LocalDate;

public class Doctor extends Person {
    private String medicalLicenceNumber;
    private String specialisation;

    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialisation){
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNumber(){
        return this.medicalLicenceNumber;
    }

}
