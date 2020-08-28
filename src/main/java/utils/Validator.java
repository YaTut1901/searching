package utils;

import java.util.stream.IntStream;

public class Validator {

    /**
     * I decided that args is array of strings in such order: w n w n w... (word, number)
     * So that's why I throw exception here, w n w n - last number is redundant,
     * n w n w - first number is redundant.
     * @param args
     * @throws RuntimeException
     * @return
     */
    public Object[] validate(String... args) {
        if (args == null) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        if (args.length % 2 == 0) {
            throw new RuntimeException("Wrong argument quantity!");
        }
        try {
            return IntStream.range(0, args.length)
                    .mapToObj(num -> num % 2 != 0 ? Integer.parseInt(args[num]) : args[num])
                    .toArray();
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong argument order!");
        }
    }
}
