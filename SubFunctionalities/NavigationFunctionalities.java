package SubFunctionalities;

import SubFunctionalities.InputValidations.ConsoleValidations;
import SubFunctionalities.FunctionalPrompts.ConsolePrompts;

public abstract class NavigationFunctionalities {

    public static String IterateOption(String task){
        System.out.printf("\t1 -----> %s", task + "\n");
        System.out.println("\t2 -----> MAIN MENU" + "\n");
        return ConsoleValidations.optionInput(1,2);
    }

    public static void goToMenu(){
        System.out.println(ConsolePrompts.ENTER_ANY_NUMBER);
        ConsoleValidations.optionInput(0, 9);
    }
}
