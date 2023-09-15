package leetcode;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库第0122题 买卖股票的最佳时机2
 **/
public class Leetcode_0122 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int sumProfit = 0;
        for (int i = 0; i < length - 1; i++) {
            if (prices[i + 1] > prices[i]) sumProfit += (prices[i + 1] - prices[i]);
        }
        return sumProfit;
    }

    public static void main(String[] args) {
        Leetcode_0122 leetcode_0122 = new Leetcode_0122();

        int[] prices1 = new int[]{7,1,5,3,6,4};
        System.out.println(leetcode_0122.maxProfit(prices1));

        int[] prices2 = new int[]{7,6,4,3,1};
        System.out.println(leetcode_0122.maxProfit(prices2));
    }

}
