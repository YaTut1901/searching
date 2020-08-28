package utils;

import units.Dictionary;

import java.util.List;

public class Searcher {
    Validator validator = new Validator();
    Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public boolean search(String... args) {
        Object[] valids = validator.validate(args);
        for(int i = 0; i < valids.length - 1; i += 2) {
            Boolean coupleCheck = doesWordsCoupleExist((String) valids[i],
                    (Integer) valids[i + 1], (String) valids[i + 2]);
            if (coupleCheck == false) {
                return coupleCheck;
            }
        }
        return true;
    }

    private boolean doesWordsCoupleExist(String firstWord, Integer spaceBetween, String secondWord) {
        List<Integer> firstWordPositions = dictionary.getWordPosition(firstWord);
        List<Integer> secondWordPositions = dictionary.getWordPosition(secondWord);
        for (Integer secondWordPosition : secondWordPositions) {
            for (Integer firstWordPosition : firstWordPositions) {
                Integer wordsBetween = secondWordPosition - firstWordPosition - 1;
                if (wordsBetween <= spaceBetween && wordsBetween > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
