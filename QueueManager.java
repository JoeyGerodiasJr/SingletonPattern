package singletonPattern;

/**
 * Singleton that holds the one centralized queue for the Pag-ibig office.
 * All help desk stations and the online monitor use this single instance.
 */
public class QueueManager {

    private static QueueManager instance;

    // the current queue number (the last number issued or reset to)
    private int currentQueueNumber;

    // prevents instantiation outside of the class
    private QueueManager() {
        currentQueueNumber = 0;
    }

    // returns the one and only instance
    public static synchronized QueueManager getInstance() {
        if (instance == null)
            instance = new QueueManager();
        return instance;
    }

    // a visitor takes the next queue number
    public synchronized int issueQueueNumber() {
        currentQueueNumber++;
        return currentQueueNumber;
    }

    // the current queue number shown on the monitor
    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    // a help desk station resets the queue to an inputted number;
    // the next visitor will receive newNumber + 1
    public synchronized void resetQueue(int newNumber) {
        if (newNumber < 0)
            throw new IllegalArgumentException("Queue number cannot be negative.");
        currentQueueNumber = newNumber;
    }
}