public class QueueManager {
    private static QueueManager instance;
    private int currentQueueNumber;


    private QueueManager() {
        this.currentQueueNumber = 0;
    }


    public static synchronized QueueManager getInstance() {
        if (instance == null) {
            instance = new QueueManager();
        }
        return instance;
    }

  
    public synchronized int issueQueueNumber() {
        return ++currentQueueNumber;
    }

      public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

       public synchronized void resetQueue(int newNumber) {
        this.currentQueueNumber = newNumber;
    }
}