import Classes.WestminsterSkinConsultationManager;
import SubFunctionalities.Prompts.ConsolePrompts;

public class Driver {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager(10);
        manager.loadData();
        mainLoop: while (true) {
            switch (manager.displayMenu()) {
                case "1" -> manager.addDoctor();
                case "2" -> manager.deleteDoctor();
                case "3" -> manager.printDoctors();
                case "4" -> manager.saveData();
                case "5" -> manager.displayGUI();
                case "6" -> {
                    System.out.println(ConsolePrompts.EXIT_PROGRAM);
                    break mainLoop;
                }
            }
        }
    }
}
