package Classes;

import Interfaces.DataEntity;

import java.time.LocalDate;

public class Doctor extends Person implements Comparable<Doctor>, DataEntity {
    private final static String FULL = "FULL"; // BASIC
    private String medicalLicenceNumber;
    private String specialisation;

    @SuppressWarnings("unused")
    public Doctor(){
        super();
    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialisation){
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNumber(){
        return this.medicalLicenceNumber;
    }

    @Override
    public String[] getData(String type) {
         String[] full = {getName(),getSurname(),getDateOfBirth().toString(),getMobileNumber(),medicalLicenceNumber,specialisation};
         String[] typical = {getName() + " " + getSurname(), medicalLicenceNumber};
         return type.equals(FULL)? full : typical;
    }

    @Override
    public void parseData(String[] data) {
        this.setName(data[0]);
        this.setSurname(data[1]);
        this.setDateOfBirth(data[2]);
        this.setMobileNumber(data[3]);
        this.medicalLicenceNumber = data[4];
        this.specialisation = data[5];
    }

    public int compareTo(Doctor o) {
        return this.getSurname().compareTo(o.getSurname());
    }

    @Override
    public String toString() {
        return super.toString() + "\nMedical Licence Number : " + this.medicalLicenceNumber + "\nSpecialisation : " + this.specialisation;
    }
}
