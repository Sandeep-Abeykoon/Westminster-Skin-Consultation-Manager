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
    public static final String LAST_NAME_SUBHEADING = "LAST NAME";

    public static String appendToHtml(String original, String append){
        String truncate = original.replace("</html>", "");
        return truncate + append + "</html>";
    }
}
