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
    public static final String DETAIL_BOX_DEFAULT_1 = "<html><br>&nbsp;DOCTOR :<br>&nbsp;DATE :<br>&nbsp;START TIME :<br>&nbsp;END TIME :<br></html>";
    public static final String DETAIL_BOX_DYNAMIC = "<html><br>&nbsp;DOCTOR : %s<br>&nbsp;DATE : %s<br>&nbsp;START TIME : %s<br>&nbsp;END TIME : %s<br></html>";
}
