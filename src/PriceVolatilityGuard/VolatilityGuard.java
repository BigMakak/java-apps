package PriceVolatilityGuard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class VolatilityGuard {

    private final Map<String, MarketStats> marketData = new ConcurrentHashMap<>();

    // The volatility factor, being that the new price update is considered suspicious if it 3x bigger than the average of the last 3 price updates for that market.
    private static final BigDecimal VOLATILITY_FACTOR = new BigDecimal("3");

    public List<PriceUpdateType> processPriceUpdates(List<PriceUpdate> priceUpdates) {
        if (priceUpdates == null) throw new IllegalArgumentException("List cannot be null");

        List<PriceUpdateType> results = new ArrayList<>();

        for (PriceUpdate update : priceUpdates) {
            if (update == null) continue;

            MarketStats stats = marketData.computeIfAbsent(update.marketId(), k -> new MarketStats());

            // 1. Logic check using the stats from the LAST 3 (before adding the current one)
            BigDecimal currentAverage = stats.getAverage();
            PriceUpdateType decision = PriceUpdateType.ACCEPTED;

            if (currentAverage.signum() > 0) {
                BigDecimal limit = currentAverage.multiply(VOLATILITY_FACTOR);
                if (update.newPrice().compareTo(limit) > 0) {
                    decision = PriceUpdateType.SUSPICIOUS;
                }
            }

            results.add(decision);

            stats.recordNewPrice(update.newPrice());
        }
        return results;
    }

    /**
     * Internal state holder.
     * Uses synchronized methods to ensure the runningTotal and Queue stay in sync.
     */
    private static class MarketStats {
        private final Queue<BigDecimal> window = new ArrayDeque<>();
        private BigDecimal runningTotal = BigDecimal.ZERO;
        private static final int MAX_WINDOW = 3;

        public synchronized void recordNewPrice(BigDecimal price) {
            window.add(price);
            runningTotal = runningTotal.add(price);

            if (window.size() > MAX_WINDOW) {
                BigDecimal removed = window.poll();
                if (removed != null) {
                    runningTotal = runningTotal.subtract(removed);
                }
            }
        }

        public synchronized BigDecimal getAverage() {
            if (window.isEmpty()) return BigDecimal.ZERO;

            return runningTotal.divide(
                    BigDecimal.valueOf(window.size()), 4, RoundingMode.HALF_UP
            );
        }
    }
}