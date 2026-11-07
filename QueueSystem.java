import java.util.Scanner;

public class QueueSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        HelpDeskStation[] stations = new HelpDeskStation[3];
        for (int i = 0; i < stations.length; i++) {
            stations[i] = new HelpDeskStation(i + 1);
        }

              QueueMonitor monitor = new QueueMonitor();

        int choice;
        do {
            System.out.println("\n=== Pag-ibig Office Centralized Queuing System ===");
            System.out.println("[1] Get Queue Number");
            System.out.println("[2] View Online Monitor");
            System.out.println("[3] Reset Queue (via Help Desk Station)");
            System.out.println("[0] Exit");
            
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int assignedNumber = QueueManager.getInstance().issueQueueNumber();
                    System.out.println("\n>> Your Queue Number is: " + assignedNumber);
                    monitor.display();
                    break;
                case 2:
                    monitor.display();
                    break;
                case 3:
                    resetQueue(sc, stations, monitor);
                    break;
                case 0:
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }

      private static void resetQueue(Scanner sc, HelpDeskStation[] stations, QueueMonitor monitor) {
        int stationChoice = readInt(sc, "Select Help Desk Station (1-3): ");
        if (stationChoice >= 1 && stationChoice <= 3) {
            int newNum = readInt(sc, "Enter new queue number to reset to: ");
            stations[stationChoice - 1].resetQueue(newNum);
            monitor.display();
        } else {
            System.out.println("Invalid station number.");
        }
    }

     private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            sc.next();
        }
        return sc.nextInt();
    }
}