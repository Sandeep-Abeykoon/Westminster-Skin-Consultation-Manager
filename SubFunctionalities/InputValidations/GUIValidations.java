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
    private static final String NOT_SELECTED = "<font color='red'>NOT SELECTED</font>";
    private static final String PAST_DATE = "<font color='red'>CANNOT BE A PAST DATE</font>";
    private static final String TOO_LONG = "<font color='red'>SESSION TOO LONG</font>";
    private static final String TOO_SHORT = "<font color='red'>SESSION TOO SHORT</font>";
    private final ArrayList<String> outputs = new ArrayList<>();
    private final String rowIndex, selectedDate, selectedStartTime, selectedEndTime;
    private String doctorId;
    private LocalTime sTime, eTime;
    public GUIValidations(String rowIndex, String date, String startTime, String endTime){
        super();
        this.rowIndex = rowIndex;
        this.selectedDate = date;
        this.selectedStartTime = startTime;
        this.selectedEndTime = endTime;
        this.doctorId = null;
        this.sTime = null;
        this.eTime = null;
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

    private boolean validateDate(){
        if(dateFormat(selectedDate)){
            if((pastDate())){
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

    public boolean validateAll(){
        return validateRow() & validateDate() & validateTime(selectedStartTime) & validateTime(selectedEndTime);
    }

    public String[] computeInputs(){
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







