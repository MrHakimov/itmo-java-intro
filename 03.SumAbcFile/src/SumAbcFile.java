import java.nio.charset.StandardCharsets;
import java.util.regex.*;
import java.util.*;
import java.io.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 25.09.2018 20:55:53
 */

public class SumAbcFile {
    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFileName = args[0];
            String outputFileName = args[1];
            int answer = 0;

            try (Scanner input = new Scanner(new File(inputFileName), "utf8")) {
                Pattern pattern = Pattern.compile("[-]?[a-j]+");
                while (input.hasNextLine()) {
                    String newString = input.nextLine().toLowerCase();
                    Matcher matcher = pattern.matcher(newString);
                    while (matcher.find()) {
                        String currentMatched = matcher.group();
                        StringBuilder currentNumber = new StringBuilder();
                        int startIndex = 0;
                        if (currentMatched.charAt(0) == '-') {
                            currentNumber.append(currentMatched.charAt(0));
                            startIndex++;
                        }
                        for (int i = startIndex; i < currentMatched.length(); i++) {
                            currentNumber.append((char)(currentMatched.charAt(i) - 'a' + '0'));
                        }
                        try {
                            answer += Integer.parseInt(currentNumber.toString());
                        } catch (NumberFormatException ex) {
                            System.out.println("Use \'-\', \'a\'-\'j\' and \'A\'-\'J\' symbols only, please.\n" +
                                    "Example: Abc -jih ... dEa");
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println("Something is not correct with input-file :\(.");
            } catch (IllegalArgumentException ex) {
                System.out.println("The encoding You need is unsupported!");
            }

            try (PrintWriter output = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFileName), StandardCharsets.UTF_8))) {
                output.println(answer);
            } catch (FileNotFoundException ex) {
                System.out.println("Something goes wrong! Output-file is not correct!");
            } catch (SecurityException ex) {
                System.out.println("Access to file is denied! Please, write a name of another file!");
            }
        } else {
            System.out.println("Please, write the names of 2 files. Write them in this format:\n" +
                    "Usage: <inputFileName.format> <outputFileName.format>");
        }
    }
}
