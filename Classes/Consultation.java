package Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Consultation{
    private static final ArrayList<Consultation> CONSULTATION_ARRAY = new ArrayList<>();
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double cost;
    private String notes;
    private Patient patient;
    private Doctor doctor;

    public Doctor getDoctor(){
        return this.doctor;
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


