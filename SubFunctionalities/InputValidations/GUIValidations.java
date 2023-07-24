package SubFunctionalities.InputValidations;

import SubFunctionalities.Prompts.GUIPrompts;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class GUIValidations extends Validations{
    private final ArrayList<String> outputPrompts = new ArrayList<>();

    public boolean nameInput(String name, int minCharCount){
        if(!(validateName(name, minCharCount))){
            outputPrompts.add(GUIPrompts.promptSelector(getErrorCode()));
            return false;
        }
        outputPrompts.add(name);
        return true;
    }

    public boolean dateInput(LocalDate date, boolean past, boolean calAge){
        if(!(validateDate(String.valueOf(date), past, calAge))){
            outputPrompts.add(GUIPrompts.promptSelector(getErrorCode()));
            return false;
        }
        outputPrompts.add(String.valueOf(getValidatedDate()));
        return true;
    }


    public boolean consultTimeInput(LocalTime check, LocalTime secondaryTime, int minDuration, int maxDuration, boolean swapped) {
        if (!(validateTimeRange(check, secondaryTime, minDuration, maxDuration, swapped))) {
            outputPrompts.add(GUIPrompts.promptSelector(getErrorCode()));
            return false;
        }
        outputPrompts.add(String.valueOf(check));
        return true;
    }

    public boolean mobileNumberInput(String number, int characters){
        if(!(validateNumber(number, characters, 0, 999999999))) {
            if (getErrorCode() == 9) {
                outputPrompts.add(number.length() <= characters ? String.format(
                        GUIPrompts.MOBILE_NUMBER_CHAR_COUNT, number.length(), characters) : GUIPrompts.INPUT_TOO_LONG);
            }
            outputPrompts.add(GUIPrompts.promptSelector(getErrorCode()));
            return false;
        }
        outputPrompts.add(String.valueOf(number));
        return true;
    }

    public boolean patientIdInput(String number, int characters){
        if(!(validateId(number, characters))){
            outputPrompts.add(GUIPrompts.promptSelector(getErrorCode()));
            return false;
        }
        outputPrompts.add(number);
        return true;

    }

    public ArrayList<String> getValidationPrompts(){
        return outputPrompts;
    }
}






