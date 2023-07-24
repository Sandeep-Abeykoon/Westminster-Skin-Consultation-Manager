package SubFunctionalities.InputValidations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class GUIValidations extends Validations{
    private final ArrayList<String> outputPrompts = new ArrayList<>();

    public String nameInput(String name, int minCharCount){
        if(!(validateName(name, minCharCount))){
            outputPrompts.add("error");
            return "";
        }
        outputPrompts.add(name);
        return name;
    }

    public boolean consultDateInput(LocalDate date){
        if(!(validateDate(String.valueOf(date), false, false))){
            outputPrompts.add("error");
            return false;
        }
        outputPrompts.add(String.valueOf(getValidatedDate()));
        return true;
    }


    public boolean consultTimeInput(LocalTime check, LocalTime secondaryTime, int minDuration, int maxDuration, boolean swapped) {
        if (!(validateTimeRange(check, secondaryTime, minDuration, maxDuration, swapped))) {
            outputPrompts.add("error");
            return false;
        }
        outputPrompts.add(String.valueOf(check));
        return true;
    }

    public ArrayList<String> getOutputPrompts(){
        return outputPrompts;
    }
}






