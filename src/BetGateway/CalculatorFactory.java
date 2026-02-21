package BetGateway;

public class CalculatorFactory {

    public static PayoutCalculator getCalculator(BetType betType) {
        return switch (betType) {
            case STANDARD -> new SingleBetCalculator();
            case RISKY -> new RiskyBetCalculator();
            case FULL_HOUSE -> new FullHouseBetCalculator();
        };
    }
}
