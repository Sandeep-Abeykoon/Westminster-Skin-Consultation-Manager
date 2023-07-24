package SubFunctionalities.Prompts;

public abstract class GUIPrompts {
    public static final String[] VIEW_TABLE_HEADERS = {"No", "First Name", "Last Name", "Date of Birth", "Mobile Number", "Medical License Number", "Specialisation"};
    public static final String[] SELECT_DOCTOR_HEADERS = {"No", "Name", "Medical License Number"};
    public static final String VIEW_DOCTORS_HEADING = "VIEW DOCTORS";
    public static final String CONSULTATIONS_HEADING = "BOOK CONSULTATION";
    public static final String SELECT_DOCTOR_SUBHEADING = "Select the doctor from the table for consultation";
    public static final String SELECT_DATE_SUBHEADING = "Select the date";
    public static final String SELECT_S_TIME_SUBHEADING = "Select the start time";
    public static final String SELECT_E_TIME_SUBHEADING = "Select the end time";
    public static final String DETAIL_BOX_SUBHEADING = "DETAILS";
    public static final String DETAIL_BOX_DEFAULT_1 = "<html><br>&ensp;DOCTOR :<br>&ensp;DATE :<br>&ensp;START TIME :<br>&ensp;END TIME :<br></html>";
    public static final String DETAIL_BOX_DYNAMIC_1 = "<html><br>&ensp;DOCTOR : %s<br>&ensp;DATE : %s<br>&ensp;START TIME : %s<br>&ensp;END TIME : %s<br></html>";
    public static final String DETAIL_BOX_DEFAULT_2 = "<html><br>&ensp;FIRST NAME :<br>&ensp;SURNAME :<br>&ensp;DATE OF BIRTH :<br>&ensp;MOBILE NUMBER :<br>&ensp;PATIENT ID :<br></html>";
    public static final String DETAIL_BOX_DYNAMIC_2 = "<html><br>&ensp;FIRST NAME : %s<br>&ensp;SURNAME : %s<br>&ensp;DATE OF BIRTH : %s<br>&ensp;MOBILE NUMBER : %s<br>&ensp;PATIENT ID : %s<br></html>";
    public static final String DOCTOR_AVAILABLE = "&emsp;&emsp;&emsp;&emsp;&emsp;<font color='green'>DOCTOR IS AVAILABLE</font>";
    public static final String NO_ANY_DOCTORS = "<font color='red>NO ANY DOCTOR AVAILABLE FOR THE SLOT</font>";
    public static final String ADD_PATIENT_DETAILS = "ADD PATIENT DETAILS";
    public static final String ADD_ADDITIONAL_DETAILS = "ADD ADDITIONAL DETAILS";
    public static final String FIRST_NAME_SUBHEADING = "FIRST NAME";
    public static final String SUR_NAME_SUBHEADING = "SURNAME";
    public static final String SELECT_DOB_SUBHEADING = "SELECT DATE OF BIRTH";
    public static final String MOBILE_NUMBER_SUBHEADING = "MOBILE NUMBER";
    public static final String DUMMY_MOBILE_NUMBER = "07x1234567";
    public static final String PATIENT_ID_SUBHEADING = "PATIENT ID";
    public static final String PATIENT_NOTE_PROMPT = "Type any notes to be included...";
    public static final String ADDITIONAL_NOTES_SUBHEADING = "ADDITIONAL NOTES";
    public static final String  ADD_IMAGE_SUBHEADING = "ADD AN IMAGE";
    public static final String AGE = "&ensp;(%s Y and %s M)";

    //----------------------------------------------------------------------------------------------------------------//
    private static final String EMPTY = "<font color='red'>EMPTY</font>";
    private static final String WHITE_SPACE_ERROR = "<font color='red'>AVOID WHITESPACES</font>";
    private static final String CHARACTER_VIOLATION_ALPHA = "<font color='red'>TYPE ONLY LETTERS</font>";
    private static final String CHARACTER_VIOLATION_NUMBER = "<font color='red'>TYPE ONLY NUMBERS</font>";
    public static final String NOT_SELECTED = "<font color='red'>NOT SELECTED</font>";
    private static final String FUTURE_DATE = "<font color='red'>A FUTURE DATE</font>";
    private static final String CHECK_AGE = "<font color='red'>AGE NOT POSSIBLE</font>";
    private static final String PAST_DATE = "<font color='red'>CANNOT BE A PAST DATE</font>";
    private static final String TOO_LONG = "<font color='red'>SESSION TOO LONG</font>";
    private static final String TOO_SHORT = "<font color='red'>SESSION TOO SHORT</font>";
    public static final String INPUT_TOO_LONG = "<font color='red'>INPUT TOO LONG</font>";
    private static final String INPUT_TOO_SHORT = "<font color='red'>INPUT TOO SHORT</font>";
    public static final String MOBILE_NUMBER_CHAR_COUNT = "<font color='red'>%s/%s</font>";
    public static final String BOOKING_CONFIRMATION_MESSAGE = """
            \tCONSULTATION DETAILS
            \t------------------------------------
            \tDOCTOR : %s
            \tDATE : %s
            \tSTART TIME : %s
            \tEND TIME %s
            \tCOST : RS %s .00
            
            \tPATIENT DETAILS
            \t------------------------
            \tFIRST NAME : %s
            \tSURNAME : %s
            \tDATE OF BIRTH : %s
            \tMOBILE NUMBER : %s
            \tPATIENT ID : %s
            
            DO YOU WANT TO CONFIRM THE BOOKING?""";


    public static String appendToHtml(String original, String append){
        String truncate = original.replace("</html>", "");
        return truncate + append + "</html>";
    }

    public static String promptSelector(int code){
        return switch (code) {
            case 1 -> EMPTY;
            case 2 -> WHITE_SPACE_ERROR;
            case 3 -> CHARACTER_VIOLATION_ALPHA;
            case 4 -> INPUT_TOO_SHORT;
            case 5 -> NOT_SELECTED;
            case 6 -> FUTURE_DATE;
            case 7 -> PAST_DATE;
            case 8 -> CHARACTER_VIOLATION_NUMBER;
            case 11 -> CHECK_AGE;
            case 13 -> TOO_LONG;
            case 14 -> TOO_SHORT;
            default -> null;
        };
    }
}
