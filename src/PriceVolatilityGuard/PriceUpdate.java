package PriceVolatilityGuard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceUpdate(String marketId, BigDecimal newPrice, LocalDateTime timestamp) {
    public void print() {
        System.out.printf("Market ID: %s || newPrice: %d || BetType: %s \r\n", marketId, newPrice.intValueExact(), timestamp.toString());
    }
}

