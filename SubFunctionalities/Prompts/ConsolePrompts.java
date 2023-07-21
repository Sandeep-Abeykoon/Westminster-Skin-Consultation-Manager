package SubFunctionalities.Prompts;

public abstract class ConsolePrompts {
    public static final String ADD_DOCTOR_OPTION = "ADD A DOCTOR";
    public static final String ADD_DOCTOR = "\n-------- ADD A DOCTOR --------\n";
    public static final String DELETE_DOCTOR_OPTION = "DELETE A DOCTOR";
    public static final String DELETE_DOCTOR = "\n-------- DELETE A DOCTOR --------\n";
    public static final String DOCTOR_REGISTERED = "\nTHE DOCTOR IS SUCCESSFULLY ADDED TO THE SYSTEM !\n";
    public static final String DOCTOR_REMOVED = "\nTHE DOCTOR IS SUCCESSFULLY REMOVED FROM THE SYSTEM !\n";
    public static final String DOCTOR_ALREADY_REGISTERED = "\nDOCTOR WITH THE MEDICAL LICENSE NUMBER : %s , IS ALREADY REGISTERED ON THE SYSTEM ! %n%n";
    public static final String NO_DOCTORS = "\nCURRENTLY THERE ARE NO DOCTORS IN THE SYSTEM !";
    public static final String NO_MATCHING_DOCTORS = "\nTHERE ARE NO DOCTORS REGISTERED UNDER THE MEDICAL LICENSE NUMBER : %s%n%n";
    public static final String DOCTORS_FULL = "\nONLY MAXIMUM NUMBER OF %s DOCTORS ARE ALLOWED IN THE SYSTEM ! %n%n";
    public static final String ENTER_ANY_NUMBER = "\nENTER ANY NUMBER TO CONTINUE TO MAIN MENU !\n";
    public static final String DASH_STREAM_65 = "-".repeat(65);
    public static final String DASH_STREAM_144 = "-".repeat(144) + "|";
    public static final String DOCTOR_DETAILS = "\n" + DASH_STREAM_65 + "DOCTOR DETAILS" + DASH_STREAM_65 + "|";
    public static final String TABLE_HEADERS = "\n\t\t|\tFIRST NAME \t\t|\tSURNAME \t\t|\tDATE OF BIRTH \t|\tMOBILE NUMBER \t|\tMEDICAL LICENCE NUMBER \t|\tSPECIALISATION\t\t\t|";
    public static final String DATA_SAVED = "\nTHE DATA IS SUCCESSFULLY SAVED !\n";
    public static final String SAVE_ERROR = "\nTHERE WAS A PROBLEM WHILE TRYING TO SAVE DATA !\n";
    public static final String LOAD_ERROR = "\nTHERE WAS A PROBLEM LOADING THE DATA TO THE SYSTEM\n";
    public static final String EXIT_PROGRAM = "\nTHANK YOU FOR USING OUR SOFTWARE AND HAVE A NICE DAY!\n";

    //----------------------------------------------------------------------------------------------------------------------//
    //Error prompts

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

}
