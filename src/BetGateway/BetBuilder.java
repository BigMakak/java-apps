package BetGateway;

public class BetBuilder {
    private String betID;
    private int customerID;
    private int stake;
    private double odd;
    private BetType betType;

    public BetBuilder setBetID(String betID) {
        this.betID = betID;
        return this;
    }

    public BetBuilder setCustomerID(int customerID) {
        this.customerID = customerID;
        return this;
    }

    public BetBuilder setStake(int stake) {
        this.stake = stake;
        return this;
    }

    public BetBuilder setOdd(double odd) {
        this.odd = odd;
        return this;
    }

    public BetBuilder setBetType(BetType betType) {
        this.betType = betType;
        return this;
    }

    public Bet build() {
        return new Bet(betID, customerID, stake, odd, betType);
    }
}
