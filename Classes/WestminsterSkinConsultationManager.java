package Classes;

import Functionalities.DoctorFunctionalities;
import Functionalities.FunctionalPrompts.ConsolePrompts;
import InputValidations.ConsoleValidations;

import java.time.LocalDate;

import java.util.ArrayList;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    private static int maxDoctors;
    private static final ArrayList<Doctor> doctorArray = new ArrayList<>();

    public WestminsterSkinConsultationManager(int maxNumberOfDoctors){
        maxDoctors = maxNumberOfDoctors;
    }
    @Override
    public String displayMenu() {
        System.out.println("""
                \n------------------------------------------------------------
                |            WESTMINSTER SKIN CONSULTANT MANAGER           |
                ------------------------------------------------------------
                |                                                          |
                |                        MAIN MENU                         |
                |                                                          |
                ------------------------------------------------------------
                |      1) Add a new Doctor   3) Print the list of Doctors  |
                |      2) Delete a Doctor    4) Save to File               |
                |      5) Display GUI        6) Exit                       |
                ------------------------------------------------------------
                
                """);

        return ConsoleValidations.optionInput(1,6);
    }

    @Override
    public void addDoctor() {
        if(doctorArray.size() < maxDoctors){
            System.out.println(ConsolePrompts.ADD_DOCTOR);
            String firstName = ConsoleValidations.nameInput("first");
            String surname = ConsoleValidations.nameInput("surname");
            LocalDate dateOfBirth = ConsoleValidations.dateInput();
            String mobileNumber = ConsoleValidations.mobileNumberInput(10);
            String medicalLicenseNumber = ConsoleValidations.medicalLicenseNumberInput();
            String specialization = ConsoleValidations.specialisationInput();

            if(!(DoctorFunctionalities.alreadyRegistered(medicalLicenseNumber))){
                doctorArray.add(new Doctor(firstName, surname, dateOfBirth, mobileNumber, medicalLicenseNumber, specialization));
                System.out.println(ConsolePrompts.DOCTOR_REGISTERED);
            }else {
                System.out.println(ConsolePrompts.DOCTOR_ALREADY_REGISTERED);
            }
        }
    }

    public static ArrayList<Doctor> getDoctorList() {
        return doctorArray;
    }
}
