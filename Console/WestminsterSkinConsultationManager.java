package Console;

import Utilities.Validation;

import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    private static int maxDoctors;

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

        return Validation.getInput(1,6);
    }

}
