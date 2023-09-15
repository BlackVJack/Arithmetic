package leetcode;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库第0121题 买卖股票的最佳时机
 **/
public class Leetcode_0121 {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxPro = 0;

        for (int price : prices) {
            int pro = price - min;
            if (pro > maxPro) maxPro = pro;
            if (price < min) min = price;
        }
        return maxPro;
    }

    public static void main(String[] args) {
        Leetcode_0121 leetcode_0121 = new Leetcode_0121();

        int[] prices1 = new int[]{7,1,5,3,6,4};
        System.out.println(leetcode_0121.maxProfit(prices1));

        int[] prices2 = new int[]{7,6,4,3,1};
        System.out.println(leetcode_0121.maxProfit(prices2));
    }

}
