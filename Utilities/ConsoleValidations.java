package Utilities;

import java.time.LocalDate;

public abstract class ConsoleValidations extends Validation {
    private static final  String OPTION = "Enter your option : ";
    private static final String FIRST_NAME = "Enter the Doctor's first name : ";
    private static final String SURNAME = "Enter the Doctor's surname name : ";
    private static final String DATE_OF_BIRTH = "Enter the date of birth in the following format (YY/MM/DD)";

    public static String optionInput(int lowerBound, int upperBound){
        String input = getInput(OPTION);
        if(checkNumerical(input) && checkBounds(input, lowerBound, upperBound)){
            return input;
        }
        System.out.println(errorMessage + "\n");
        optionInput(lowerBound, upperBound);
        return null;
    }

    public static String nameInput(String nameCategory){
        String category = nameCategory.equals("first") ? FIRST_NAME : SURNAME;
        String input = getInput(category);
        if(checkWhiteSpaces(input) && containsOtherCharacters(input)){
            return input;
        }
        System.out.println(errorMessage + "\n");
        nameInput(nameCategory);
        return null;
    }

    public static LocalDate dateInput(){
        String input = getInput(DATE_OF_BIRTH);
        if(checkWhiteSpaces(input) && dateFormat(input) && futureDateOfBirth() && dateAgeRange(20, 60)){
            return date;
        }
        System.out.println(errorMessage + "\n");
        dateInput();
        return null;
    }
}
