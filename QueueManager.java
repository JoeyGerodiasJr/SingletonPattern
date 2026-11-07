package singletonPattern;

public class QueueManager {

    private static QueueManager instance;


    private int currentQueueNumber;


    private QueueManager() {
        currentQueueNumber = 0;
    }

      public static synchronized QueueManager getInstance() {
        if (instance == null)
            instance = new QueueManager();
        return instance;
    }


    public synchronized int issueQueueNumber() {
        currentQueueNumber++;
        return currentQueueNumber;
    }


    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

      public synchronized void resetQueue(int newNumber) {
        if (newNumber < 0)
            throw new IllegalArgumentException("Queue number cannot be negative.");
        currentQueueNumber = newNumber;
    }
}