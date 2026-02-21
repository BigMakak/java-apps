package PriceVolatilityGuard;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VolatilityGuard guard = new VolatilityGuard();
        String marketIdOne = "MATCH_001";
        String marketIdTwo = "MATCH_002";

        List<PriceUpdate> updates = List.of(
                new PriceUpdate(marketIdOne, new BigDecimal("1.50"), LocalDateTime.now()),
                new PriceUpdate(marketIdOne, new BigDecimal("1.60"), LocalDateTime.now()),
                new PriceUpdate(marketIdOne, new BigDecimal("1.55"), LocalDateTime.now()),
                new PriceUpdate(marketIdOne, new BigDecimal("10.00"), LocalDateTime.now()),
                new PriceUpdate(marketIdOne, new BigDecimal("1.58"), LocalDateTime.now()),
                new PriceUpdate(marketIdOne, new BigDecimal("1.58"), LocalDateTime.now()),
                new PriceUpdate(marketIdOne, new BigDecimal("20.58"), LocalDateTime.now()),
                new PriceUpdate(marketIdTwo, new BigDecimal("2.00"), LocalDateTime.now()),
                new PriceUpdate(marketIdTwo, new BigDecimal("3.00"), LocalDateTime.now()),
                new PriceUpdate(marketIdTwo, new BigDecimal("25.00"), LocalDateTime.now())
        );

        List<PriceUpdateType> decisions = guard.processPriceUpdates(updates);

        for (int i = 0; i < updates.size(); i++) {
            System.out.println("Market: " + updates.get(i).marketId() + " Update: " + updates.get(i).newPrice() + " -> Result: " + decisions.get(i));
        }
    }
}
