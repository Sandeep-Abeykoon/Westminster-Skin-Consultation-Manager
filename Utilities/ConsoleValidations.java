package Utilities;

import java.time.LocalDate;

public abstract class ConsoleValidations extends Validation {
    private static final  String OPTION_PROMPT = "Enter your option : ";
    private static final String FIRST_NAME_PROMPT = "Enter the Doctor's first name : ";
    private static final String SURNAME_PROMPT = "Enter the Doctor's surname name : ";
    private static final String DATE_OF_BIRTH_PROMPT = "Enter the date of birth in the following format (YY-MM-DD) : ";

    public static String optionInput(int lowerBound, int upperBound) {
        String input = getInput(OPTION_PROMPT);
        if (!(checkNumerical(input) && checkBounds(input, lowerBound, upperBound))) {
            System.out.println(errorMessage + "\n");
            return optionInput(lowerBound, upperBound);
        }
        return input;
    }


    public static String nameInput(String nameCategory){
        String category = nameCategory.equals("first") ? FIRST_NAME_PROMPT : SURNAME_PROMPT;
        String input = getInput(category).substring(0, 1).toUpperCase();
        if(!(checkWhiteSpaces(input) && containsOtherCharacters(input))){
            System.out.println(errorMessage + "\n");
            return nameInput(nameCategory);
        }
        return input;
    }
    

    public static LocalDate dateInput(){
        String input = getInput(DATE_OF_BIRTH_PROMPT);
        if(!(checkWhiteSpaces(input) && dateFormat(input) && futureDateOfBirth() && dateAgeRange(20, 60))){
            System.out.println(errorMessage + "\n");
            return dateInput();
        }
        return date;
    }
}
