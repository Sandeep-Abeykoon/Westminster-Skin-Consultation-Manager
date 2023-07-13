package SubFunctionalities.Console;

import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;
import SubFunctionalities.FunctionalPrompts.ConsolePrompts;

import java.util.ArrayList;
import java.util.Collections;


public abstract class DoctorFunctionalities {

    public static Doctor alreadyRegistered(String medicalLicenceNumber) {
        for (Doctor doctor : WestminsterSkinConsultationManager.getDoctorList()) {
            if (doctor.getMedicalLicenceNumber().equals(medicalLicenceNumber)) {
                return doctor;
            }
        }
        return null;
    }

    public static ArrayList<Doctor> sortedDoctorArray() {
        ArrayList<Doctor> copy = new ArrayList<>(WestminsterSkinConsultationManager.getDoctorList());
        Collections.sort(copy);
        return copy;
    }

    public static void printHeader() {
        System.out.println(ConsolePrompts.TABLE_HEADERS);
        System.out.println(ConsolePrompts.DASH_STREAM_144);
    }

    public static void printDetails(Doctor doctor) {
        System.out.printf("%-20s%-20s%-20s%-20s%-28s%-20s%n", (Object[]) doctor.getData("FULL"));
    }
}

