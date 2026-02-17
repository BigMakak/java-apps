package Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BreakingRecords {

    public List<Integer> breakingRecords(List<Integer> scores) {

        if (scores.isEmpty()) {
            return Collections.emptyList();
        }

        int lowestScore = scores.get(0), highestScore = scores.get(0);
        Integer[] scoreCounters = {0, 0};

        for (int i = 1; i < scores.size(); i++) {
            if (lowestScore > scores.get(i)) {
                lowestScore = scores.get(i);
                scoreCounters[1]++;
            }

            if (highestScore < scores.get(i)) {
                highestScore = scores.get(i);
                scoreCounters[0]++;
            }
        }

        return Arrays.asList(scoreCounters);
    }
}
