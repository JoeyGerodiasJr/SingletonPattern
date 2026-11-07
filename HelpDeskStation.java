package singletonPattern;


public class HelpDeskStation {

    private final int stationNumber;

    public HelpDeskStation(int stationNumber) {
        this.stationNumber = stationNumber;
    }


    public void resetQueue(int newNumber) {
        QueueManager.getInstance().resetQueue(newNumber);
        System.out.println("Station " + stationNumber + " reset the queue to " + newNumber + ".");
    }
}