package Utilities;

public abstract class ConsoleValidations extends Validation {
    private static final  String OPTION = "Enter your option : ";
    private static final String FIRST_NAME = "Enter the Doctor's first name : ";
    private static final String SURNAME = "Enter the Doctor's surname name : ";
    private static final String DATE_OF_BIRTH = "Enter the date of birth in the following format (DD/MM/YY)";

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
        nameInput(nameCategory);
        return null;
    }

    public static String dateInput(String dateCategory){
        String input = getInput(DATE_OF_BIRTH);

    }
}
