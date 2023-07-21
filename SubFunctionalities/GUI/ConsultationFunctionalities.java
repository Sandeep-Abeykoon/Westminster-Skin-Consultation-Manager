package SubFunctionalities.GUI;

import Classes.Consultation;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class ConsultationFunctionalities {
    public static boolean getDoctorAvailability(String doctorId, LocalDate date, LocalTime startTime, LocalTime endTime){
        for(Consultation consultation : Consultation.getConsultations()){
            if(consultation.getDoctorId().equals(doctorId)){
                if(consultation.getDate().equals(date)){
                    if(!(startTime.isAfter(consultation.getEndTime())) || !(endTime.isBefore(consultation.getStartTime()))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
