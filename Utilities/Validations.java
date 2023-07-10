package Utilities;

public abstract class Validations extends Validation {
    private static final  String OPTION = "Enter your option : ";
    private static final String FIRST_NAME = "Enter the Doctor's first name : ";
    private static final String LAST_NAME = "Enter the Doctor's last name : ";

    public static String optionInput(int lowerBound, int upperBound){
        String input = getInput(OPTION);
        if(checkNumerical(input, false) && checkBounds(input, lowerBound, upperBound)){
            return input;
        }
        optionInput(lowerBound, upperBound);
        return null;
    }

    public static String nameInput(String nameCategory){
        String category = nameCategory.equals("first") ? FIRST_NAME : LAST_NAME;
        String input = getInput(category);
        if(checkNumerical(input, true) && containsNumbers(input)){
            return input;
        }
        nameInput(nameCategory);
        return null;
    }
}
