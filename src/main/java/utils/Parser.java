package utils;

public class Parser {
    public String[] parse(String text) {
        return text.toLowerCase().replaceAll("[^A-Za-z ]", "").split(" ");
    }
}
