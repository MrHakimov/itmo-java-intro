import java.util.*;
import java.io.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 13.10.2018 14:29:59
 */

public class ReverseSum {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> mainMatrix = new ArrayList<>();
        FastScanner input = new FastScanner(System.in);
        int currentIndex = 0;
        while (input.hasNextLine()) {
            String newString = input.nextLine();
            mainMatrix.add(new ArrayList<>());
            StringBuilder current = new StringBuilder();
            for (int i = 0; i <= newString.length(); i++) {
                if (i == newString.length() || Character.isWhitespace(newString.charAt(i))) {
                    if (current.length() != 0) {
                        try {
                            mainMatrix.get(currentIndex).add(Integer.parseInt(current.toString()));
                            current = new StringBuilder();
                        } catch (NumberFormatException ex) {
                            System.out.println("Use \'-\' and \'0\'-\'9\' symbols only, please.\n" +
                                    "Example: 100 -14 ... 435");
                        }
                    }
                    continue;
                }
                current.append(newString.charAt(i));
            }
            currentIndex++;
        }
        ArrayList<Integer> sumOfLines = new ArrayList<>();
        ArrayList<Integer> sumOfColumns = new ArrayList<>();
        for (int i = 0; i < mainMatrix.size(); i++) {
            int curSumOfLine = 0;
            for (int j = 0; j < mainMatrix.get(i).size(); j++) {
                curSumOfLine += mainMatrix.get(i).get(j);
                if (sumOfColumns.size() >= j + 1) {
                    sumOfColumns.set(j, sumOfColumns.get(j) + mainMatrix.get(i).get(j));
                } else {
                    sumOfColumns.add(mainMatrix.get(i).get(j));
                }
            }
            sumOfLines.add(curSumOfLine);
        }
        for (int i = 0; i < mainMatrix.size(); i++) {
            for (int j = 0; j < mainMatrix.get(i).size(); j++) {
                System.out.print((sumOfLines.get(i) + sumOfColumns.get(j) - mainMatrix.get(i).get(j)) + " ");
            }
            System.out.println();
        }
    }
}
