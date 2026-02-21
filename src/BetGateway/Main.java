package BetGateway;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BetBuilder builder = new BetBuilder();
        Bet bet1 = builder.setBetID("100").setCustomerID(101).setStake(50).setOdd(1.5).setBetType(BetType.STANDARD).build();
        Bet bet2 = builder.setBetID("101").setCustomerID(102).setStake(100).setOdd(2.0).setBetType(BetType.RISKY).build();
        Bet bet3 = builder.setBetID("103").setCustomerID(102).setStake(100).setOdd(2.0).setBetType(BetType.FULL_HOUSE).build();
        Bet bet4 = builder.setBetID("104").setCustomerID(103).setStake(10).setOdd(2.0).setBetType(BetType.STANDARD).build();

        BetServiceCalculator service = new BetServiceCalculator(List.of(bet1, bet2, bet3, bet4));
        List<Bet> highValueBets = service.getHighValueBets();

        for (Bet bet : highValueBets) {
            System.out.println("High Value Bet:");
            bet.print();
        }

        BetRegistry.Instance().print();
    }
}
