package Classes;

import java.time.LocalDate;

public class Doctor extends Person implements Comparable<Doctor>{
    private final String medicalLicenceNumber;
    private final String specialisation;

    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialisation){
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNumber(){
        return this.medicalLicenceNumber;
    }

    public String getSpecialisation(){
        return this.specialisation;
    }

    public int compareTo(Doctor o) {
        return this.getSurname().compareTo(o.getSurname());
    }

    public void printDetails() {
        System.out.printf("%-20s%-20s%-20s%-20s%-28s%-20s%n", this.getName(), this.getSurname(), this.getDateOfBirth(), this.getMobileNumber(), this.medicalLicenceNumber, this.specialisation);
    }

    @Override
    public String toString() {
        return super.toString() + "\nMedical Licence Number : " + this.medicalLicenceNumber + "\nSpecialisation : " + this.specialisation;
    }
}
