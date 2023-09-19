package leetcode;

import java.util.*;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/17 21:32
 *
 * 力扣题库第0135题 分发糖果
 *
 */
public class Leetcode_0135 {

    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] candies = new int[length + 2];
        int[] newRatings = new int[length + 2];
        System.arraycopy(ratings, 0, newRatings, 1, length);

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < length; i++) {
            priorityQueue.offer(new int[] {i + 1, ratings[i]});
        }

        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
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

    public int candy2(int[] ratings) {
        int length = ratings.length;
        int[] candies = new int[length + 2];
        int[] ratings_ = new int[length + 2];


        System.arraycopy(ratings, 0, ratings_, 1, length);

        int count = 0;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            while (j < length && ratings[j] >= ratings[j - 1]) j++;
            setCandy1(ratings, candies, i, j);
            i = j - 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            int j = i - 1;
            while (j >= 0 && ratings[j] >= ratings[j + 1]) j--;
            setCandy2(ratings, candies, i, j);
            i = j + 1;
        }


        System.out.print("ratings: ");showArray(ratings);
        System.out.print("candies: ");showArray(candies);
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }


    public void setCandy1(int[] ratings, int[] candies, int start, int end) {

        if (candies[start] != 0) return;
        if (end - start == 1) {
            return;
        }
        candies[start] = 1;
        for (int i = start + 1; i < end - 1; i++) {
            if (ratings[i] != ratings[i - 1]) candies[i] = candies[i - 1] + 1;
            else candies[i] = 1;
        }
        if (end >= ratings.length) {
            if (ratings[ratings.length - 1] == ratings[ratings.length - 2])
                candies[ratings.length - 1] = 1;
            else candies[ratings.length - 1] = candies[ratings.length - 2] + 1;
        }
    }

    public void setCandy2(int[] ratings, int[] candies, int start, int end) {
        if (candies[start] != 0) return;
        if (end - start == 1) {
            return;
        }
        candies[start] = 1;
        for (int i = start - 1; i > 0; i--) {
            if (candies[i] != 0) continue;
            if (ratings[i] != ratings[i + 1]) candies[i] = candies[i + 1] + 1;
            else candies[i] = 1;
        }

        if (end < 0) {
            if (ratings[0] == ratings[1])
                candies[0] = 1;
            else candies[0] = candies[1] + 1;
        }

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
        leetcode_0135.showAnswer(ratings1);

        int[] ratings2 = {1, 2, 2};
        leetcode_0135.showAnswer(ratings2);


        int[] ratings3 = {1,2,87,87,87,2,1};
        leetcode_0135.showAnswer(ratings3);


        int[] ratings4 = {2,2};
        leetcode_0135.showAnswer(ratings4);

        int[] ratings5 = {1,2,4,4,3};
        leetcode_0135.showAnswer(ratings5);


        int[] ratings6 = {29,51,87,87,72,12};
        leetcode_0135.showAnswer(ratings6);
    }


    public void showAnswer(int[] ratings) {
        System.out.println();
        int answer = this.candy2(ratings);
        System.out.println("方法2答案: " + answer);
        System.out.println("标准答案: " + this.candy(ratings));
        System.out.println("是否正确: " + (this.candy(ratings) == answer));
        System.out.println();
    }

}
