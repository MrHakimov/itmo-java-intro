import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 01.10.2018 00:01:46
 */

public class WordStatWords {
    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFileName = args[0];
            String outputFileName = args[1];
            Map<String, Integer> counter = new TreeMap<>();
            int defaultValue = 1;
            try (Scanner input = new Scanner(new File(inputFileName), "utf8")) {
                while (input.hasNextLine()) {
                    String newString = input.nextLine();
                    for (String currentWord: newString.toLowerCase().split("[^\\p{L}\\p{Pd}\\']")) {
                        if (currentWord.isEmpty()) {
                            continue;
                        }
                        if (counter.containsKey(currentWord)) {
                            counter.put(currentWord, counter.get(currentWord) + 1);
                        } else {
                            counter.put(currentWord, defaultValue);
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println("Something is goes wrong with input-file!");
            } catch (IllegalArgumentException ex) {
                System.out.println("The encoding You need is unsupported!");
            }
            try (PrintWriter output = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFileName), StandardCharsets.UTF_8))) {
                counter.entrySet().stream().
                        forEach(entry -> output.println(entry.getKey() + " " + entry.getValue()));
            } catch (FileNotFoundException ex) {
                System.out.println("Some error ocured while opening or writing to output-file :\(.");
            } catch (SecurityException ex) {
                System.out.println("Access to file is denied! Please, write a name of another file!");
            }
        } else {
            System.out.println("Please, write the names of 2 files. Write them in this format:\n" +
                    "Usage: <inputFileName.format> <outputFileName.format>");
        }
    }
}