package Utilities;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Validation {
    protected static String errorMessage = "";
    private final static Scanner scanner = new Scanner(System.in);
    private final static String EMPTY_MESSAGE = "THE INPUT CANNOT BE EMPTY !";
    private final static String NUMERICAL_INVALID_MESSAGE = "ONLY NUMERICAL INPUT IS ALLOWED !";
    private final static String INVALID_BOUNDS_MESSAGE = "PLEASE ENTER AN OPTION BETWEEN %s AND %s ! %n";
    private final static String WHITE_SPACE_MESSAGE = "A NAME CANNOT HAVE WHITESPACES !";
    private final static String INVALID_WORD_MESSAGE = "ONLY LETTERS CAN BE INCLUDED !";

    protected static String getInput(String prompt){
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if(isEmpty(input)){
            getInput(prompt);
        }
        return input;
    }

    protected static boolean isEmpty(String input){
        if(input.equals("")){
            System.out.println(EMPTY_MESSAGE + "\n");
            return true;
        }
        return false;
    }

    protected static boolean checkNumerical(String input){
        try{
            int d = Integer.parseInt(input);
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
        errorMessage = INVALID_BOUNDS_MESSAGE;
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


}

