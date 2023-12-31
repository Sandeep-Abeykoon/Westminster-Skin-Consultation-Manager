package SubFunctionalities.InputValidations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validations {
    private static int errorCode;
    private static int lowerBound;
    private static int upperBound;
    private static LocalDate date;

    // Main Functionalities
    protected static boolean validateName(String name, int minCharCount){
        if (!(basicInputValidation(name,false, false))){
            return false;
        }
        if (!(containsOnlyLetters(name))){
            return setError(3);
        }
        if (!(minCharacterCount(name, minCharCount))){
            return setError(4);
        }
        return true;
    }

    protected static boolean validateDate(String inputDate, boolean past, boolean calAge) {
        if (!(basicInputValidation(inputDate,false, false))) {
            return false;
        }
        if (!(dateFormat(inputDate))){
            return setError(12);
        }
        if (past != pastDate(date)) {
            return setError(past ? 6 : 7);
        }
        if (calAge && !(dateAgeRange(date, lowerBound, upperBound))){
            return setError(11);
        }
        return true;
    }

    protected static boolean validateTimeRange(LocalTime check, LocalTime secondaryTime, int minDuration, int maxDuration, boolean timeSwapped){
        if (check == null){
            return setError(5);
        }
        if(!(secondaryTime == null)){
            LocalTime
            time1 = timeSwapped? secondaryTime : check,
            time2 = timeSwapped? check : secondaryTime;

            Duration duration = Duration.between(time1, time2);
            if(duration.toHours() > maxDuration){
                return setError(13);
            } else if (duration.toMinutes() < minDuration) {
                return setError(14);
            }
        }
        return true;
    }

    protected static boolean validateNumber(String number, int characters, int lowerBound, int upperBound){
        if (!(basicInputValidation(number, false, false))){
            return false;
        }
        if (!(containsOnlyNumbers(number))){
            return setError(8);
        }
        if (!(characterCount(number, characters))){
            return setError(9);
        }
        if (!(checkBounds(number, lowerBound, upperBound))){
            return setError(10);
        }
        return true;
    }

    protected static boolean validateId(String idNumber, int characters){
        if (!(basicInputValidation(idNumber, false, false))) {
            return false;
        }
        if (!(minCharacterCount(idNumber, characters))){
            return setError(4);
        }
        return true;
    }

    public static boolean basicInputValidation(String input, boolean whiteSpacesAllowed, boolean minCharTrigger){
        if(input == null || input.equals("null")){
            return setError(5);
        }
        if (isEmpty(input)){
            return setError(1);
        }
        if (!whiteSpacesAllowed & checkWhiteSpaces(input)){
            return setError(2);
        }
        if(minCharTrigger && !(minCharacterCount(input, lowerBound))){
            return setError(4);
        }
        return true;
    }

    //----------------------------------------------------------------------------------------------------------------//

    public static LocalDate getValidatedDate(){
        return date;
    }


    protected static int getErrorCode(){
        return errorCode;
    }

    // Sub Functionalities
    private static boolean setError(int error){
        errorCode = error;
        return false;
    }

    public static void setLowerAndUpperBound(int newLowerBound, int newUpperBound){
        lowerBound = newLowerBound;
        upperBound = newUpperBound;
    }

    public static String getLowerBound(){
        return String.valueOf(lowerBound);
    }

    public static void setLowerBound (int newLowerBound){
        lowerBound = newLowerBound;
    }

    public static String getUpperBound(){
        return String.valueOf(upperBound);
    }

    //----------------------------------------------------------------------------------------------------------------//

    private static boolean isEmpty(String input) {
        return input.equals("");
    }

    private static boolean checkWhiteSpaces(String input){
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        return (matcher.find());
    }

    private static boolean containsOnlyLetters(String input){
        return input.matches("[a-zA-Z]+");
    }

    private static boolean minCharacterCount(String input, int size){
        return input.length() >= size;
    }

    private static boolean dateFormat(String input){
        try {
           date =  LocalDate.parse(input, DateTimeFormatter.ofPattern("u-M-d").withResolverStyle(ResolverStyle.STRICT));
           return true;
        } catch (Exception e) {
            return false;
        }
    }


    private static boolean pastDate(LocalDate date){
        return date.isBefore(LocalDate.now());
    }

    private static boolean dateAgeRange(LocalDate date, int minAge, int maxAge){
        int difference = (Period.between(date, LocalDate.now())).getYears();
        return difference >= minAge && difference <= maxAge;
    }

    private static boolean containsOnlyNumbers(String input){
        return input.matches("[0-9]+");
    }

    private static boolean characterCount(String input, int size){
        return input.length() == size;
    }

    private static boolean checkBounds(String input, int lowerBound, int upperBound){
        int value = Integer.parseInt(input);
        return value >= lowerBound && value <= upperBound;
    }
}

