import java.io.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 13.10.2018 15:01:32
 */

public class FastScanner {
    private InputStream inpStr;
    private int currentPosition, currentSize;

    public FastScanner(InputStream input) {
        inpStr = input;
    }

    private int size = 128;
    private byte[] buffer = new byte[size];


    private void readBytes() throws IOException {
        currentSize = inpStr.read(buffer, 0, size);
        currentPosition = 0;
    }

    boolean hasNextLine() throws IOException {
        if (currentSize <= currentPosition) {
            readBytes();
        }
        return (currentSize > currentPosition);
    }

    public String nextLine() throws IOException {
        if (currentPosition >= currentSize) {
            readBytes();
        }
        StringBuilder readString = new StringBuilder();
        while (currentPosition < currentSize && !(buffer[currentPosition] == '\n')) {
            char currentSymbol = (char)(buffer[currentPosition]);
            currentPosition++;
            readString.append(currentSymbol);
            if (currentPosition >= currentSize) {
                readBytes();
            }
        }
        if (currentPosition < currentSize) {
            currentPosition++;
        }
        return readString.toString();
    }
}
