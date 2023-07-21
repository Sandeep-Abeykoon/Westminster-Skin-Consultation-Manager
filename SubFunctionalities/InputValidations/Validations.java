package SubFunctionalities.InputValidations;

import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Validations {
    protected static final ArrayList<Doctor> doctorArray = WestminsterSkinConsultationManager.getDoctorList();

    protected static LocalDate date;
    protected static String errorMessage = "";
    private final static Scanner scanner = new Scanner(System.in);
    private final static String EMPTY_MESSAGE = "THE INPUT CANNOT BE EMPTY !";
    private final static String NUMERICAL_INVALID_MESSAGE = "ONLY NUMERICAL INPUT IS ALLOWED !";
    private final static String INVALID_BOUNDS_MESSAGE = "PLEASE ENTER AN OPTION BETWEEN %s AND %s !";
    private final static String WHITE_SPACE_MESSAGE = "THE INPUT CANNOT HAVE WHITESPACES !";
    private final static String INVALID_WORD_MESSAGE = "ONLY LETTERS CAN BE INCLUDED !";
    private final static String INVALID_DATE_MESSAGE = "ENTER A DATE WHICH MATCHES THE GIVEN DATE FORMAT !";
    private final static String FUTURE_DATE_OF_BIRTH_MESSAGE = "THE DATE OF BIRTH CANNOT BE A FUTURE DATE !";
    private final static String INVALID_AGE_MESSAGE = "THE AGE SHOULD BE BETWEEN %s AND %s !";
    private final static String INVALID_CHARACTER_COUNT_MESSAGE = "INPUT HAVING %s CHARACTERS SHOULD BE ENTERED !";
    private final static String MIN_CHARACTER_COUNT_MESSAGE = "THE INPUT SHOULD HAVE AT LEAST MINIMUM OF %s CHARACTERS !";

    protected static String getInput(String prompt){
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if(isEmpty(input)){
            System.out.println(EMPTY_MESSAGE + "\n");
            getInput(prompt);
        }
        return input;
    }

    protected static boolean isEmpty(String input) {
        return input.equals("");
    }


    protected static boolean checkNumerical(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            errorMessage = NUMERICAL_INVALID_MESSAGE;
            return false;
        }
        return true;
    }

    protected static boolean checkBounds(String input, int lowerBound, int upperBound){
        int value = Integer.parseInt(input);
        if(value >= lowerBound && value <= upperBound){
            return true;
        }
        errorMessage = String.format(INVALID_BOUNDS_MESSAGE, lowerBound, upperBound);
        return false;
    }

    protected static boolean checkWhiteSpaces(String input){
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            errorMessage = WHITE_SPACE_MESSAGE;
            return false;
        }
        return true;
    }

    protected static boolean containsOtherCharacters(String input){
        if(input.matches("[a-zA-Z]+")){
            return true;
        }
        errorMessage = INVALID_WORD_MESSAGE;
        return false;
    }

    protected static boolean containsOnlyNumbers(String input){
        if(input.matches("[0-9]+")){
            return true;
        }
        errorMessage = NUMERICAL_INVALID_MESSAGE;
        return false;
    }

    protected static boolean dateFormat(String input){
        try{
            date = LocalDate.parse(input, DateTimeFormatter.ofPattern("u-M-d").withResolverStyle(ResolverStyle.STRICT));
        }catch (DateTimeParseException e){
            errorMessage = INVALID_DATE_MESSAGE;
            return false;
        }
        return true;
    }

    protected static boolean pastDate(){
        if(date.isBefore(LocalDate.now())){
            return true;
        }
        errorMessage = FUTURE_DATE_OF_BIRTH_MESSAGE;
        return false;
    }

    protected static boolean dateAgeRange(int minAge, int maxAge){
        int difference = (Period.between(date, LocalDate.now())).getYears();
        if(difference >= minAge && difference <= maxAge){
            return true;
        }
        errorMessage = String.format(INVALID_AGE_MESSAGE, minAge, maxAge);
        return false;
    }

    protected static boolean characterCount(String input, int size){
        if(input.length() == size){
            return true;
        }
        errorMessage = String.format(INVALID_CHARACTER_COUNT_MESSAGE, size);
        return false;
    }

    protected static boolean minCharacterCount(String input, int size){
        if(input.length() >= size){
            return true;
        }
        errorMessage = String.format(MIN_CHARACTER_COUNT_MESSAGE, size);
        return false;
    }
}

