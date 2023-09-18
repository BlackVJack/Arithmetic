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
        int[] candies = new int[length];
        int sum = 0;

        Queue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        for (int i = 0; i < length; i++) {
            queue.offer(new int[]{i, ratings[i]});
        }

        int minRating = queue.peek()[1];
        int change = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int rating = poll[1];
            if (rating != minRating) {
                minRating = rating;
                change++;
            }
            candies[poll[0]] = change;
        }

        if (length > 1 && ratings[0] == ratings[1]) {
            ratings[0] = 1;
        }
        for (int i = 1; i < length - 1; i++) {
            if (ratings[i - 1] == ratings[i] && ratings[i] == ratings[i + 1]) {
                candies[i] = 1;
            }
        }
        if (ratings[length - 2] == ratings[length - 1]) {
            candies[length - 1] = 1;
        }

        System.out.println(Arrays.toString(candies));
        for (int i : candies) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
