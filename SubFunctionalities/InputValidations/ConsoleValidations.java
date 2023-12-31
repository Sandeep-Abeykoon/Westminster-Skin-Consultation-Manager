package SubFunctionalities.InputValidations;

import SubFunctionalities.Prompts.ConsolePrompts;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class ConsoleValidations extends Validations {
    private final static Scanner scanner = new Scanner(System.in);

    private static String getInput(String prompt){
        System.out.print(prompt);
        return scanner.nextLine().trim();
        }

    private static void printError(String... args){
        String formattedString = String.format(ConsolePrompts.promptSelector(getErrorCode()), (Object[]) args);
        System.out.println(formattedString + "\n");
    }

    public static String optionInput(int characters, int lowerBound, int upperBound) {
        String input = getInput(ConsolePrompts.OPTION_PROMPT);
        if (!(validateNumber(input, characters, lowerBound, upperBound))) {
            printError(String.valueOf(lowerBound), String.valueOf(upperBound));
            return optionInput(characters, lowerBound, upperBound);
        }
        return input;
    }


    public static String nameInput(String nameCategory, int minCharCount){
        String category = nameCategory.equals("first") ? ConsolePrompts.FIRST_NAME_PROMPT : ConsolePrompts.SURNAME_PROMPT;
        String input = getInput(category).toLowerCase();
        if(!(validateName(input, minCharCount))){
            printError();
            return nameInput(nameCategory, minCharCount);
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }


    public static LocalDate dateInput(boolean past, boolean calAge){
        String input = getInput(ConsolePrompts.DATE_OF_BIRTH_PROMPT);
        if(!(validateDate(input, past, calAge))){
            printError(getLowerBound(), getUpperBound());
            return dateInput(past, calAge);
        }
        return getValidatedDate();
    }

    public static String mobileNumberInput(int count){
        String input = getInput(ConsolePrompts.MOBILE_NUMBER_PROMPT);
        if(!(validateNumber(input, count, 0, 999999999))){
            printError(String.valueOf(count));
            return mobileNumberInput(count);
        }
        return input;
    }

    public static String medicalLicenseNumberInput(int charCount){
        String input = getInput(ConsolePrompts.MEDICAL_LICENSE_NUMBER_PROMPT);
        if(!(validateId(input, charCount))){
            printError(String.valueOf(charCount));
            return medicalLicenseNumberInput(charCount);
        }
        return input;
    }

    public static String specialisationInput(){
        String input = getInput(ConsolePrompts.SPECIALISATION_PROMPT);
        if(!(basicInputValidation(input, true, true))){
            printError(getLowerBound());
            return specialisationInput();
        }
        return input;
    }
}
