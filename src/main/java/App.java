import utils.Parser;
import utils.Reader;
import utils.Searcher;

public class App {
    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        Reader reader = new Reader();
        Parser parser = new Parser();
        String[] words = parser.parse(reader.read("src/test/resources/test_1.txt"));
        searcher.getDictionary().addAll(words);
        System.out.println(searcher.search("door", "3", "painted", "0", "porthole"));
    }
}
