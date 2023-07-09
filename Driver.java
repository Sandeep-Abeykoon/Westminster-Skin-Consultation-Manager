import Console.WestminsterSkinConsultationManager;

public class Driver {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager(10);

        while (true) {
            switch (manager.displayMenu()) {
                case "1":
                    System.out.println("hi");
            }
        }
    }
}
