public class HelpDeskStation {
    private int stationNumber;

       public HelpDeskStation(int stationNumber) {
        this.stationNumber = stationNumber;
    }
    public void resetQueue(int newNumber) {
        QueueManager.getInstance().resetQueue(newNumber);
        System.out.println("[Station " + stationNumber + "] Queue reset to: " + newNumber);
    }
}