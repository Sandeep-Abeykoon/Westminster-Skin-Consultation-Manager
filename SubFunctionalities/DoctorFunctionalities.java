package SubFunctionalities;

import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;

public abstract class DoctorFunctionalities {

    public static Doctor alreadyRegistered(String medicalLicenceNumber) {
        for(Doctor doctor: WestminsterSkinConsultationManager.getDoctorList()){
            if(doctor.getMedicalLicenceNumber().equals(medicalLicenceNumber)){
                return doctor;
            }
        }
        return null;
    }
}

