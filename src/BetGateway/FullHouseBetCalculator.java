package BetGateway;

public class FullHouseBetCalculator implements PayoutCalculator {

    @Override
    public double calculate(Bet bet) {
        if (bet.odd() > 2.0) {
            return bet.stake() * bet.odd() * 0.9; // Apply a 10% reduction for high odds
        } else {
            return bet.stake() * bet.odd(); // Standard payout for lower odds
        }
    }
}
