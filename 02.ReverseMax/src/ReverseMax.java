import java.util.*;

/**
 * @author: Muhammadjon Hakimov
 * created: 18.09.2018 09:56:43
 */

public class ReverseMax {
    public static void main(String[] args) {
        List<List<Integer>> mainArray = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int curIndex = 0;
        while (input.hasNextLine()) {
            mainArray.add(new ArrayList<>());
            for (String curNumber: input.nextLine().split("\\s")) {
                if (!curNumber.isEmpty()) {
                    mainArray.get(curIndex).add(Integer.parseInt(curNumber));
                }
            }
            curIndex++;
        }
        for (int i = 0; i < mainArray.size(); i++) {
            for (int j = 0; j < mainArray.get(i).size(); j++) {
                int maxOfColumn = mainArray.get(i).get(0), maxOfLine = Integer.MIN_VALUE;
                for (int k = 1; k < mainArray.get(i).size(); k++) {
                    maxOfColumn = Math.max(maxOfColumn, mainArray.get(i).get(k));
                }
                for (int k = 0; k < mainArray.size(); k++) {
                    if (mainArray.get(k).size() >= j + 1) {
                        maxOfLine = Math.max(maxOfLine, mainArray.get(k).get(j));
                    }
                }
                System.out.print(Math.max(maxOfColumn, maxOfLine) + " ");
            }
            System.out.println();
        }
    }
}