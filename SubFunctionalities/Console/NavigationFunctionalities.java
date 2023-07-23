package SubFunctionalities.Console;

import SubFunctionalities.InputValidations.ConsoleValidations;
import SubFunctionalities.Prompts.ConsolePrompts;

public abstract class NavigationFunctionalities {

    public static String IterateOption(String task){
        System.out.printf("\t1 -----> %s", task + "\n");
        System.out.println("\t2 -----> MAIN MENU" + "\n");
        return ConsoleValidations.optionInput(1,1,2);
    }

    public static void goToMenu(){
        System.out.println(ConsolePrompts.ENTER_ANY_NUMBER);
        ConsoleValidations.optionInput( 1, 0, 9);
    }
}
