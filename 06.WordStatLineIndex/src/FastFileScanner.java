import java.nio.charset.StandardCharsets;
import java.io.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 01.11.2018 02:24:11 by Daniel Korolev, edited: 03.11.2018 20:05:32 by Muhammadjon Hakimov
 */

public class FastFileScanner implements AutoCloseable {
    private char currentSymbol;
    private final InputStreamReader input;
    private static final byte EOF = -1;
    private static final char NEW_LINE = '\n';
    private static final char APOSTROPHE = '\'';

    public FastFileScanner(String fileName) throws IOException {
        input = new InputStreamReader(new FileInputStream(new File(fileName)), StandardCharsets.UTF_8);
    }

    private void readNextChar() throws IOException {
        currentSymbol = (char)input.read();
    }

    public boolean hasNextLine() throws IOException {
        readNextChar();
        return (byte)currentSymbol != EOF;
    }

    private boolean inCurrentLine() {
        return currentSymbol != NEW_LINE && (byte)currentSymbol != EOF;
    }

    public String nextWord() throws IOException {
        StringBuilder currentWord = new StringBuilder();
        while (!isCorrectSymbol(currentSymbol)) {
            readNextChar();
            if (!inCurrentLine()) {
                return "";
            }
        }
        while (isCorrectSymbol(currentSymbol)) {
            currentWord.append(currentSymbol);
            readNextChar();
        }
        return currentWord.toString().toLowerCase();
    }

    private boolean isCorrectSymbol(char symbol) {
        return Character.isLetter(symbol)
                || Character.getType(symbol) == Character.DASH_PUNCTUATION
                || symbol == APOSTROPHE;
    }

    public void close() throws IOException {
        input.close();
    }
}
