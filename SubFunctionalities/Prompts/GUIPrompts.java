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
    public static final String DETAIL_BOX_DYNAMIC = "<html><br>&ensp;DOCTOR : %s<br>&ensp;DATE : %s<br>&ensp;START TIME : %s<br>&ensp;END TIME : %s<br></html>";
    public static final String DOCTOR_AVAILABLE = "&emsp;&emsp;&emsp;&emsp;&emsp;<font color='green'>DOCTOR IS AVAILABLE</font>";
    public static final String NO_ANY_DOCTORS = "<font color='red>NO ANY DOCTOR AVAILABLE FOR THE SLOT</font>";
    public static final String ADD_PATIENT_DETAILS = "ADD PATIENT DETAILS";
    public static final String FIRST_NAME_SUBHEADING = "FIRST NAME";
    public static final String SUR_NAME_SUBHEADING = "SURNAME";
    public static final String SELECT_DOB_SUBHEADING = "SELECT DATE OF BIRTH";
    public static final String MOBILE_NUMBER_SUBHEADING = "MOBILE NUMBER";
    public static final String DUMMY_MOBILE_NUMBER = "07x1234567";
    public static final String PATIENT_ID_SUBHEADING = "PATIENT ID";
    public static final String PATIENT_NOTE_PROMPT = "Type any notes to be included...";

    public static String appendToHtml(String original, String append){
        String truncate = original.replace("</html>", "");
        return truncate + append + "</html>";
    }
}
