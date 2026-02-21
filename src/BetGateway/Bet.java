package BetGateway;

public record Bet(String betID, int customerID, int stake, double odd ,BetType betType) {
    public void print() {
        System.out.printf("BetID: %s || CustomerID: %d || Stake: %d || Odd: %.2f || BetType: %s \r\n", betID, customerID, stake, odd, betType);
    }
}


