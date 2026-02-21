package BetGateway;

public class RiskyBetCalculator implements PayoutCalculator {
    private final double RISK_MULTIPLIER = 0.8;

    @Override
    public double calculate(Bet bet) {
        return bet.stake() * bet.odd() * RISK_MULTIPLIER;

    }
}
