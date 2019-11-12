import java.math.BigInteger;

/**
 * @author: Muhammadjon Hakimov
 * created: 11.09.2018 10:03:00
 */

public class SumBigInteger {
    public static void main(String[] args) {
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < args.length; i++) {
            for (String num: args[i].split("[^0-9-]")) {
                try {
                    BigInteger cur_add = new BigInteger(num);
                    ans = ans.add(cur_add);
                } catch (NumberFormatException ex) {
                }
            }
        }
        System.out.println(ans);
    }
}