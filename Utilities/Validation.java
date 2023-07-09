package Utilities;

import java.util.Scanner;

public abstract class Validation {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String emptyMessage = "The input cannot be empty !";
    private final static String invalidMessage = "Only Numerical input is allowed !";
    private final static String invalidBoundsMessage = "Please enter a number between %s and %s ! %n%n";

    public static String getInput(int lowerBound, int upperBound){
        System.out.print("Enter your option : ");
        return integerValidation(scanner.nextLine(), lowerBound, upperBound);
    }
    private static String integerValidation(String input, int lowerBound, int upperBound){
        input = input.trim();
        if(isEmpty(input) && checkNumerical(input) && checkBounds(input, lowerBound, upperBound)){
            return input;
        }
        getInput(lowerBound, upperBound);
        return null;
    }

    private static boolean isEmpty(String input){
        if(input.equals("")){
            System.out.println(emptyMessage + "\n");
            return false;
        }
        return true;
    }

    private static boolean checkNumerical(String input){
        try{
            int d = Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println(invalidMessage + "\n");
            return false;
        }
        return true;
    }

    private static boolean checkBounds(String input, int lowerBound, int upperBound){
        int value = Integer.parseInt(input);
        if(value >= lowerBound && value <= upperBound){
            return true;
        }
        System.out.printf(invalidBoundsMessage, lowerBound, upperBound);
        return false;
    }
}
