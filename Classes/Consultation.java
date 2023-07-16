package Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consultation{
    private static final ArrayList<Consultation> CONSULTATION_ARRAY = new ArrayList<>();
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double cost;
    private String notes;
    private String patientId;
    private String doctorId;

    public String getDoctorId(){
        return this.doctorId;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public LocalTime getStartTime(){
        return this.startTime;
    }

    public LocalTime getEndTime(){
        return this.endTime;
    }
    public static ArrayList<Consultation> getConsultations(){
        return CONSULTATION_ARRAY;
    }
}


