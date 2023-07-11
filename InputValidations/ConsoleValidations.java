package InputValidations;

import java.time.LocalDate;

public abstract class ConsoleValidations extends Validations {
    private static final  String OPTION_PROMPT = "Enter your option : ";
    private static final String FIRST_NAME_PROMPT = "Enter the Doctor's first name : ";
    private static final String SURNAME_PROMPT = "Enter the Doctor's surname name : ";
    private static final String DATE_OF_BIRTH_PROMPT = "Enter the date of birth in the following format (YY-MM-DD) : ";
    private static final String MOBILE_NUMBER_PROMPT = "Enter the mobile phone number in the following format 07x1234567 : ";
    private static final String MEDICAL_LICENSE_NUMBER_PROMPT = "Enter the medical license number : ";
    private static final String SPECIALISATION_PROMPT = "Enter the specialisation : ";

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
        String input = getInput(category).toLowerCase();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        if(!(checkWhiteSpaces(input) && containsOtherCharacters(input) && minCharacterCount(input, 3))){
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

    public static String mobileNumberInput(int count){
        String input = getInput(MOBILE_NUMBER_PROMPT);
        if(!(checkWhiteSpaces(input) && containsOnlyNumbers(input) && characterCount(input, count))){
            System.out.println(errorMessage + "\n");
            return mobileNumberInput(count);
        }
        return input;
    }

    public static String medicalLicenseNumberInput(){
        String input = getInput(MEDICAL_LICENSE_NUMBER_PROMPT);
        if(!(checkWhiteSpaces(input) && minCharacterCount(input, 5))){
            System.out.println(errorMessage + "\n");
            return medicalLicenseNumberInput();
        }
        return input;
    }

    public static String specialisationInput(){
        String input = getInput(SPECIALISATION_PROMPT);
        if(!(checkWhiteSpaces(input) && minCharacterCount(input, 2))){
            System.out.println(errorMessage + "\n");
            return medicalLicenseNumberInput();
        }
        return input;
    }
}
