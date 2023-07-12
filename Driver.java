import Classes.WestminsterSkinConsultationManager;

public class Driver {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager(10);

        while (true) {
            switch (manager.displayMenu()) {
                case "1" -> manager.addDoctor();
                case "2" -> manager.deleteDoctor();
                case "3" -> manager.printDoctors();
                case "4" -> manager.saveData();
            }
        }
    }
}
