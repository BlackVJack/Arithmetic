package leetcode;

import java.util.*;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/17 21:32
 *
 * 力扣题库第0135题 分发糖果 (未完成)
 *
 */
public class Leetcode_0135 {

    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] candies = new int[length + 2];
        int[] newRatings = new int[length + 2];
        System.arraycopy(ratings, 0, newRatings, 1, length);

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < length; i++) {
            queue.offer(new int[] {i + 1, ratings[i]});
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int rating = poll[1];

            int preRating = newRatings[index - 1];
            int nxtRating = newRatings[index + 1];
            // TODO 情况1 中间最小(也可以等于): 111, 212, 211, 112, 置为1 - 则可以使得总糖果数量最少
            if (preRating >= rating && nxtRating >= rating) {
                candies[index] = 1;
            }
            // TODO 情况2 中间最大 - 取最大+1 则可以满足题目条件
            else if (preRating < rating && nxtRating < rating) {
                candies[index] = Math.max(candies[index - 1], candies[index + 1]) + 1;
            }
            else {
                // TODO 情况3.1 321
                if (preRating > nxtRating) {
                    candies[index] = Math.max(candies[index - 1] - 1, candies[index + 1] + 1);
                }
                // TODO 情况3.2 123
                else {
                    candies[index] = Math.max(candies[index + 1] - 1, candies[index - 1] + 1);
                }

            }
            sum += candies[index];
        }
        return sum;
    }


    public void showArray(int[] nums) {
        for (int num : nums) {
            System.out.printf("%2d, ", num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Leetcode_0135 leetcode_0135 = new Leetcode_0135();

        int[] ratings1 = {1, 0, 2};
        System.out.println(leetcode_0135.candy(ratings1));


        int[] ratings2 = {1, 2, 2};
        System.out.println(leetcode_0135.candy(ratings2));

        int[] ratings3 = {1,2,87,87,87,2,1};
        System.out.println(leetcode_0135.candy(ratings3));

        int[] ratings4 = {2,2};
        System.out.println(leetcode_0135.candy(ratings4));

        int[] ratings5 = {1,2,4,4,3};
        System.out.println(leetcode_0135.candy(ratings5));
    }

}
