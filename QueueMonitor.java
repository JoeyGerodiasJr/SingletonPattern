public class QueueMonitor {

    public void display() {
        int currentNumber = QueueManager.getInstance().getCurrentQueueNumber();
        System.out.println("\n--- Online Queue Monitor ---");
        System.out.println("Current Queued Number: " + currentNumber);
        System.out.println("----------------------------\n");
    }
}