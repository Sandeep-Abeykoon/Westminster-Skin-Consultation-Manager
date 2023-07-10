package Utilities;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validation {
    protected final static Scanner scanner = new Scanner(System.in);
    private final static String EMPTY_MESSAGE = "The input cannot be empty !";
    private final static String NUMERICAL_INVALID_MESSAGE = "Only Numerical input is allowed !";
    private final static String WORD_INVALID_MESSAGE = "Only Numerical input is allowed !";
    private final static String INVALID_BOUNDS_MESSAGE = "Please enter an option between %s and %s %n";
    private final static String WHITE_SPACE_MESSAGE = "A name cannot have whitespaces !";
    private final static String NUMBERS_IN_WORD_MESSAGE = "Numbers cannot be included !";

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

    protected static boolean checkNumerical(String input, boolean word){
        try{
            int d = Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println(word ? WORD_INVALID_MESSAGE : NUMERICAL_INVALID_MESSAGE + "\n");
            return false;
        }
        return true;
    }

    protected static boolean checkBounds(String input, int lowerBound, int upperBound){
        int value = Integer.parseInt(input);
        if(value >= lowerBound && value <= upperBound){
            return true;
        }
        System.out.printf(INVALID_BOUNDS_MESSAGE, lowerBound, upperBound + " !\n");
        return false;
    }

    protected static boolean checkWhiteSpace(String input){
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            System.out.println(WHITE_SPACE_MESSAGE + "\n");
            return false;
        }
        return true;
    }

    protected static boolean containsNumbers(String input){
        if(input.matches("[a-zA-Z]+")){
            return true;
        }
        System.out.println(NUMBERS_IN_WORD_MESSAGE + "\n");
        return false;
    }
}

