package EventCounter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class EventCounter {

    private final Map<EventCounterType, AtomicInteger> eventCounter = new ConcurrentHashMap<EventCounterType, AtomicInteger>();

    public void recordEvent(EventCounterType eventType) {
        validateType(eventType);

        eventCounter.computeIfAbsent(eventType, k ->
                new AtomicInteger(0)).incrementAndGet();
    }

    public int getCount(EventCounterType eventType) throws IllegalArgumentException {
        validateType(eventType);

        return eventCounter.getOrDefault(eventType, new AtomicInteger(0)).get();
    }

    public int getTotalCount() {
        int totalCount = 0;

        for(var entry : eventCounter.entrySet()) {
            totalCount += entry.getValue().get();
        }
        return totalCount;
    }

    public void print() {
        System.out.println(eventCounter);
    }

    private void validateType(EventCounterType eventType) {
        if(eventType == null) {
            throw new IllegalArgumentException("Event type cannot be null");
        }
    }
}
