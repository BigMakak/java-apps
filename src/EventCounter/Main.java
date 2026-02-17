package EventCounter;

public class Main {
    public static void main(String[] args) {
        EventCounter eventCounter = new EventCounter();

        eventCounter.recordEvent(EventCounterType.LOGIN);
        eventCounter.recordEvent(EventCounterType.LOGOUT);
        eventCounter.recordEvent(EventCounterType.LOGIN);
        eventCounter.recordEvent(EventCounterType.LOGIN);

        eventCounter.print();
    }
}
