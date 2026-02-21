package BetGateway;

public class SingleBetCalculator implements PayoutCalculator {

    @Override
    public double calculate(Bet bet) {
        return bet.stake() * bet.odd();
    }
}
