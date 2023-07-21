package SubFunctionalities.InputValidations;

import Classes.Doctor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GUIValidations extends Validations {
    private static final int MIN_CONSULTATION_TIME = 5;
    private static final int MAX_CONSULTATION_TIME = 12;
    private static final int MOBILE_NUMBER_CHARACTERS = 10;
    private static final String NOT_SELECTED = "<font color='red'>NOT SELECTED</font>";
    private static final String PAST_DATE = "<font color='red'>CANNOT BE A PAST DATE</font>";
    private static final String FUTURE_DATE = "<font color='red'>A FUTURE DATE</font>";
    private static final String TOO_LONG = "<font color='red'>SESSION TOO LONG</font>";
    private static final String TOO_SHORT = "<font color='red'>SESSION TOO SHORT</font>";
    private static final String INPUT_TOO_LONG = "<font color='red'>INPUT TOO LONG</font>";
    private static final String EMPTY = "<font color='red'>EMPTY</font>";
    private static final String CHARACTER_VIOLATION_ALPHA = "<font color='red'>TYPE ONLY LETTERS</font>";
    private static final String CHARACTER_VIOLATION_NUMERICAL = "<font color='red'>TYPE ONLY NUMBERS</font>";
    private static final String WHITE_SPACE_ERROR = "<font color='red'>AVOID WHITESPACES</font>";
    private static final String NAME_TOO_SHORT = "<font color='red'>NAME TOO SHORT</font>";
    private static final String MOBILE_NUMBER_CHAR_COUNT = "<font color='red'>%s/" + MOBILE_NUMBER_CHARACTERS + "</font>";
    private static final String MIN_CHARACTER_COUNT_VIOLATION = "<font color='red'>MINIMUM CHARACTERS : " + MOBILE_NUMBER_CHARACTERS + "</font>";
    private final ArrayList<String> outputs = new ArrayList<>();
    private String rowIndex, selectedDate, selectedStartTime, selectedEndTime;
    private String firstName, surName, dateOfBirth, mobileNumber, patientId;
    private String doctorId;
    private LocalTime sTime, eTime;
    public GUIValidations(String rowIndex, String consultDate, String startTime, String endTime){
        super();
        this.rowIndex = rowIndex;
        this.selectedDate = consultDate;
        this.selectedStartTime = startTime;
        this.selectedEndTime = endTime;

        this.doctorId = null;
        this.sTime = null;
        this.eTime = null;
        date = null;
    }

    public GUIValidations(String firstName, String surname, String dateOfBirth, String mobileNumber, String patientId){
        super();
        this.firstName = firstName;
        this.surName = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.patientId = patientId;
        date = null;
    }

    private boolean validateRow(){
        if(rowIndex.equals("-1")){
            outputs.add(NOT_SELECTED);
            return false;
        }
        Doctor doctor = doctorArray.get(Integer.parseInt(rowIndex));
        doctorId = doctor.getMedicalLicenceNumber();
        String fullName = "Dr "+ doctor.getName() + " " + doctor.getSurname();
        outputs.add(fullName);
        return true;
    }

    private boolean validateConsultationDate(){
        if(dateFormat(selectedDate)){
            if(pastDate()){
                outputs.add(PAST_DATE);
                return false;
            }
        } else if (date == null) {
            outputs.add(NOT_SELECTED);
            return false;
        }
        outputs.add(String.valueOf(date));
        return true;
    }

    private boolean validateDateOfBirth(){
        if(dateFormat(dateOfBirth)){
            if(!pastDate()){
                outputs.add(FUTURE_DATE);
                return false;
            }
        } else if (date == null) {
            outputs.add(NOT_SELECTED);
            return false;
        }
        outputs.add(String.valueOf(date));
        return true;
    }

    private boolean validateTime(String input){
        if(input.equals("")){
            outputs.add(NOT_SELECTED);
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        if(!(selectedStartTime.equals("") || selectedEndTime.equals(""))){
            sTime = LocalTime.parse(selectedStartTime, formatter);
            eTime = LocalTime.parse(selectedEndTime, formatter);

            Duration duration = Duration.between(sTime,eTime);
            if (duration.toHours() > MAX_CONSULTATION_TIME){
                outputs.add(TOO_LONG);
                return false;
            } else if(duration.toMinutes() < MIN_CONSULTATION_TIME){
                outputs.add(TOO_SHORT);
                return false;
            }
        }
        outputs.add(input);
        return true;
    }

    private boolean validateName(String name) {
        if (isEmpty(name)) {
            outputs.add(EMPTY);
            return false;
        }
        if(!(checkWhiteSpaces(name))) {
            outputs.add(WHITE_SPACE_ERROR);
            return false;
        }
        if(!(containsOtherCharacters(name))){
            outputs.add(CHARACTER_VIOLATION_ALPHA);
            return false;
        }
        if (!(minCharacterCount(name,3))) {
            outputs.add(NAME_TOO_SHORT);
            return false;
       }
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        outputs.add(name);
        return true;
    }


    private boolean validateMobileNumber(){
        if(isEmpty(mobileNumber)){
            outputs.add(EMPTY);
            return false;
        }
        if (!(checkWhiteSpaces(mobileNumber))){
            outputs.add(WHITE_SPACE_ERROR);
            return false;
        }
        if (!(containsOnlyNumbers(mobileNumber))){
            outputs.add(CHARACTER_VIOLATION_NUMERICAL);
            return false;
        }
        if (!(characterCount(mobileNumber, MOBILE_NUMBER_CHARACTERS))){
            outputs.add((mobileNumber.length() <= MOBILE_NUMBER_CHARACTERS)? String.format(MOBILE_NUMBER_CHAR_COUNT,mobileNumber.length()) : INPUT_TOO_LONG);
            return false;
        }
        outputs.add(mobileNumber);
        return true;
    }

    private boolean validatePatientId(){
        if(checkWhiteSpaces(patientId)){
            outputs.add(EMPTY);
            return false;
        } else if (minCharacterCount(patientId, 10)) {
            outputs.add(MIN_CHARACTER_COUNT_VIOLATION);
            return false;
        }
        return true;
    }


    public boolean validateConsultation(){
        return validateRow() & validateConsultationDate() & validateTime(selectedStartTime) & validateTime(selectedEndTime);
    }

    public boolean validatePatient(){
        return validateName(firstName) & validateName(surName) & validateDateOfBirth() & validateMobileNumber() & validatePatientId();
    }

    public String[] getOutputs(){
        return outputs.toArray(new String[0]);
    }

    public String getDoctorId(){
        return doctorId;
    }

    public LocalDate getDate(){
        return date;
    }

    public LocalTime getStartTime(){
        return sTime;
    }

    public LocalTime getEndTime(){
        return eTime;
    }
}







