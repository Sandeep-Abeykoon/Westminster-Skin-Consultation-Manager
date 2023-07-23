package SubFunctionalities.GUI;

import Classes.Consultation;
import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;

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

    public static Doctor getDoctor(int index){
        return index == -1? null : WestminsterSkinConsultationManager.getDoctorList().get(index);
    }
}
