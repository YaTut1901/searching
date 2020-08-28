package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    public String read(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("This file does not exist!", e);
        }
    }
}
