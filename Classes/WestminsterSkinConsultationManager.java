package Classes;

import Utilities.ConsoleValidations;

import java.time.LocalTime;
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
            System.out.println("\n-------- ADD A Doctor --------\n");
            String firstName = ConsoleValidations.nameInput("first");
            String surname = ConsoleValidations.nameInput("surname");
            LocalTime dateOfBirth =
        }
    }
}
