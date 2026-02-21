package BetGateway;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BetRegistry {

    private final Map<BetType, List<Bet>> processedBets = new ConcurrentHashMap<>();

    private BetRegistry() {}

    private static class BetRegistryHolder {
        private static final BetRegistry INSTANCE = new BetRegistry();
    }

    public static BetRegistry Instance() {
        return BetRegistryHolder.INSTANCE;
    }

    public void registerBet(Bet bet) {
        if (bet == null) {
            throw new IllegalArgumentException("Bet cannot be null");
        }
        processedBets.computeIfAbsent(bet.betType(), value ->
                new CopyOnWriteArrayList<>()).add(bet);
    }

    public void print() {
        for (var entry : processedBets.entrySet()) {
            System.out.println("Registered Bet Type: " + entry.getKey());
            for (Bet bet : entry.getValue()) {
                bet.print();
            }
        }
    }
}
