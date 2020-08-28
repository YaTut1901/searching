package utils;

import units.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    Validator validator = new Validator();
    Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public boolean search(String... args) {
        Object[] valids = validator.validate(args);
        List<Integer> previousPair_secondElementPositions = dictionary.getWordPositions((String) valids[0]);
        for (int i = 0; i < valids.length - 1; i += 2) {
            previousPair_secondElementPositions =
                    getSecondWordPositions(previousPair_secondElementPositions,
                            (Integer) valids[i + 1], (String) valids[i + 2]);
            if (previousPair_secondElementPositions.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getSecondWordPositions(List<Integer> previousPair_secondElementPositions, Integer requiredSpaceBetween, String secondWord) {
        List<Integer> thisPair_secondWordPositions = new ArrayList<>();
        List<Integer> secondWordPositions = dictionary.getWordPositions(secondWord);
        for (Integer firstWordPosition : previousPair_secondElementPositions) {
            for (Integer secondWordPosition : secondWordPositions) {
                Integer spaceBetween = secondWordPosition - firstWordPosition - 1;
                if ((spaceBetween <= requiredSpaceBetween && spaceBetween > 0)
                        || (spaceBetween == 0 && secondWordPosition > firstWordPosition)) {
                    thisPair_secondWordPositions.add(secondWordPosition);
                }
            }
        }
        return thisPair_secondWordPositions;
    }
}
