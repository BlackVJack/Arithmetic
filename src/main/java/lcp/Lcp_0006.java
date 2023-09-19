package lcp;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/20 0:28
 *
 * 力扣题库LCP0006题 拿硬币
 */
public class Lcp_0006 {

    public int minCount(int[] coins) {

        int sum = 0;
        for (int coin : coins) {
            sum += Math.ceil(coin / 2.0);
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
