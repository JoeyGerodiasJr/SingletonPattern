package singletonPattern;


public class QueueMonitor {


    public void display() {
        int current = QueueManager.getInstance().getCurrentQueueNumber();
        System.out.println("[Online Monitor] Current queued number: " + current);
    }
}