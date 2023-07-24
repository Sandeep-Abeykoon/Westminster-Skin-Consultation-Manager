package Classes;

import Interfaces.DataEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consultation extends Patient implements DataEntity {
    private static final ArrayList<Consultation> CONSULTATION_ARRAY = new ArrayList<>();
    private String doctorId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double cost;
    private String patientId;
    private String notes;

    public Consultation(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String patientId,
                        String doctorId, LocalDate date, LocalTime startTime, LocalTime endTime, double cost, String notes){
        super(name, surname, dateOfBirth, mobileNumber, patientId);

        this.doctorId = doctorId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.notes = notes;

    }

    @SuppressWarnings("unused")
    public Consultation(){
        super();
    }

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

    public static ArrayList<Consultation> getConsultationArray(){
        return CONSULTATION_ARRAY;
    }

    @Override
    public String[] getData(String type) {
        return new String[0];
    }

    @Override
    public void parseData(String[] data) {
    }

    public void parseData(Object[] data){
    }
}


