package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private final Map<String, List<Integer>> dictionary;

    private final Map<Integer, String> numerator;

    public Dictionary() {
        dictionary = new TreeMap<>();
        numerator = new TreeMap<>();
    }

    public boolean addAll(String[] words) {
        for(int i = 0; i < words.length; i++) {
            addWord(words[i], i + 1);
        }
        return true;
    }

    public Integer firstOccasion(String word) {
        return dictionary.get(word).get(0);
    }

    public boolean addWord(String word, Integer position) {
        numerator.put(position, word);
        if (dictionary.containsKey(word)) {
            dictionary.get(word).add(position);
            return true;
        }
        dictionary.put(word, new ArrayList<>(List.of(position)));
        return true;
    }

    public List<Integer> getWordPositions(String word) {
        return dictionary.get(word);
    }

    public String getWordByPosition(Integer position) {
        return numerator.get(position);
    }

    public boolean doesWordExist(String word) {
        return dictionary.containsKey(word);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String word : dictionary.keySet()) {
            builder.append(word).append(dictionary.get(word)).append("\n");
        }
        return builder.toString();
    }
}
