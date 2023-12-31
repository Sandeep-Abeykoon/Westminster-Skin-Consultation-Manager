package Classes;

import GUI.Menu;
import Interfaces.SkinConsultationManager;
import SubFunctionalities.CommonFunctionalities;
import SubFunctionalities.Console.DoctorFunctionalities;
import SubFunctionalities.InputValidations.Validations;
import SubFunctionalities.Prompts.ConsolePrompts;
import SubFunctionalities.InputValidations.ConsoleValidations;
import SubFunctionalities.Console.NavigationFunctionalities;

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

        return ConsoleValidations.optionInput(1,1,6);
    }

    @Override
    public void addDoctor() {
        System.out.println(ConsolePrompts.ADD_DOCTOR);
        if(doctorArray.size() < maxDoctors){
            String firstName = ConsoleValidations.nameInput("first", 3);
            String surname = ConsoleValidations.nameInput("surname", 3);

            Validations.setLowerAndUpperBound(20, 60);
            LocalDate dateOfBirth = ConsoleValidations.dateInput(true, true);

            String mobileNumber = ConsoleValidations.mobileNumberInput(10);
            String medicalLicenseNumber = ConsoleValidations.medicalLicenseNumberInput(5);

            Validations.setLowerBound(3);
            String specialization = ConsoleValidations.specialisationInput();

            if((DoctorFunctionalities.alreadyRegistered(medicalLicenseNumber) == null)){
                doctorArray.add(new Doctor(firstName, surname, dateOfBirth, mobileNumber, medicalLicenseNumber, specialization));
                System.out.println(ConsolePrompts.DOCTOR_REGISTERED);
            }else {
                System.out.printf(ConsolePrompts.DOCTOR_ALREADY_REGISTERED, medicalLicenseNumber);
            }
            if(NavigationFunctionalities.IterateOption(ConsolePrompts.ADD_DOCTOR_OPTION).equals("1")){
                addDoctor();
            }
        }else{
            System.out.printf(ConsolePrompts.DOCTORS_FULL, maxDoctors);
            NavigationFunctionalities.goToMenu();
        }
    }

    @Override
    public void deleteDoctor() {
        System.out.println(ConsolePrompts.DELETE_DOCTOR);
        if (!(doctorArray.size() == 0)){
            String medicalLicenseNumber = ConsoleValidations.medicalLicenseNumberInput(5);
            Doctor doctor = DoctorFunctionalities.alreadyRegistered(medicalLicenseNumber);
            if(doctor == null){
                System.out.printf(ConsolePrompts.NO_MATCHING_DOCTORS, medicalLicenseNumber);
            }else {
                System.out.println(doctor);
                doctorArray.remove(doctor);
                System.out.println(ConsolePrompts.DOCTOR_REMOVED);
            }
            if(NavigationFunctionalities.IterateOption(ConsolePrompts.DELETE_DOCTOR_OPTION).equals("1")){
                deleteDoctor();
            }
        }else{
            System.out.println(ConsolePrompts.NO_DOCTORS);
            NavigationFunctionalities.goToMenu();
        }
    }

    @Override
    public void printDoctors() {
        if (!(doctorArray.size() == 0)){
            int count = 1;
            ArrayList<Doctor> sortedArray = DoctorFunctionalities.sortedDoctorArray();
            System.out.println(ConsolePrompts.DOCTOR_DETAILS);
            DoctorFunctionalities.printHeader();

            for(Doctor doctor: sortedArray){
                System.out.print("\t" + count + "\t\t");
                DoctorFunctionalities.printDetails(doctor);
                System.out.println(ConsolePrompts.DASH_STREAM_144);
                count++;
            }
        }else {
            System.out.println(ConsolePrompts.NO_DOCTORS);
        }
        NavigationFunctionalities.goToMenu();
    }

    @Override
    public void saveData() {
        CommonFunctionalities.writeData("TextFiles/doctors.txt", doctorArray, "FULL");
    }

    @Override
    public void loadData() {
        CommonFunctionalities.loadData("TextFiles/doctors.txt", doctorArray, Doctor.class);
    }

    @Override
    public void displayGUI() {
        new Menu();
    }

    public static ArrayList<Doctor> getDoctorList() {
        return doctorArray;
    }
}
