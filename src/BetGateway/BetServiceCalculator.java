package BetGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class BetServiceCalculator {
    private final List<Bet> bets = new CopyOnWriteArrayList<>();

    public BetServiceCalculator(List<Bet> bets) {
        this.bets.addAll(bets);
    }

    public List<Bet> getHighValueBets() {
        List<Bet> highValueBets = new ArrayList<>();
        Map<Bet, Double> payoutCache = new HashMap<>();

        for (Bet bet : bets) {
            if(bet == null) {
                continue;
            }

            PayoutCalculator calculator = getPayoutCalculator(bet.betType());
            double payout = calculator.calculate(bet);


            if (payout > 50 && bet.stake() > 10) {
                highValueBets.add(bet);
                payoutCache.put(bet, payout);
            }

            BetRegistry.Instance().registerBet(bet);
        }

        highValueBets.sort((b1, b2) -> Double.compare(
                payoutCache.get(b2),
                payoutCache.get(b1)
        ));

        return highValueBets;
    }


    private PayoutCalculator getPayoutCalculator(BetType betType) {
        return CalculatorFactory.getCalculator(betType);
    }
}
