import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 01.11.2018 01:12:21
 */

public class WordStatLineIndex {
    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFileName = args[0];
            String outputFileName = args[1];
            Map<String, List<Integer>> wordsIndexes = new HashMap<>();
            try (FastFileScanner input = new FastFileScanner(inputFileName)) {
                int rowNumber = 1;
                while (input.hasNextLine()) {
                    String currentWord = input.nextWord();
                    int columnNumber = 1;
                    while (!currentWord.isEmpty()) {
                        List<Integer> currentNumbers = new ArrayList<>();
                        if (wordsIndexes.containsKey(currentWord)) {
                            currentNumbers = wordsIndexes.get(currentWord);
                        }
                        currentNumbers.add(rowNumber);
                        currentNumbers.add(columnNumber);
                        wordsIndexes.put(currentWord, currentNumbers);
                        columnNumber++;
                        currentWord = input.nextWord();
                    }
                    rowNumber++;
                }
            } catch (IOException ex) {
                System.out.println("Something is wrong with your input-file. Please, check it.");
            }

            try (PrintWriter output = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFileName), StandardCharsets.UTF_8))) {
                wordsIndexes.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
                    output.print(entry.getKey() + " " + Integer.toString(entry.getValue().size() / 2));
                    for (int i = 0; i < entry.getValue().size(); i += 2)
                        output.print(" " + entry.getValue().get(i).toString() +
                                ":" + entry.getValue().get(i + 1).toString());
                    output.println();
                });
            } catch (IOException ex) {
                System.out.println("Something is wrong with your output-file. Please, check it.");
            } catch (SecurityException ex) {
                System.out.println("Access to output-file is denied! Please, write a name of accessible file!");
            }
        } else {
            System.out.println("Please, write the names of 2 files. Write them correct!\n" +
                    "Usage: \"inputFileName\" \"outputFileName\"");
        }
    }
}
