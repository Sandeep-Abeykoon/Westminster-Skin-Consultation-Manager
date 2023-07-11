package Functionalities;

import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;

public abstract class DoctorFunctionalities {

    public static boolean alreadyRegistered(String medicalLicenceNumber) {
        for(Doctor doctor: WestminsterSkinConsultationManager.getDoctorList()){
            if(doctor.getMedicalLicenceNumber().equals(medicalLicenceNumber)){
                return true;
            }
        }
        return false;
    }
}

