package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 16:48
 *
 * 力扣题库第0084题
 *      给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *      求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Leetcode_0084 {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] h = new int[length + 2];
        for (int i = 0; i < length; i++) {
            h[i + 1] = heights[i];
        }

        int size = 0;
        int[] stack = new int[length + 2];
        stack[size++] = h[0];
        int max = 0;
        for (int i = 1; i < length + 2; i++) {
            int num = h[i];
            if (num <= h[stack[size - 1]]) {
                while (size != 0 && h[stack[size - 1]] > num) {
                    int idx = stack[size - 1];
                    size--;

                    int temp = h[idx] * (i - stack[size - 1] - 1);
                    if (temp > max) max = temp;
                }
            }
            stack[size++] = i;
        }
        return max;
    }


    public static void main(String[] args) {
        Leetcode_0084 leetcode_0084 = new Leetcode_0084();
        int[] height1 = new int[] {2,1,5,6,2,3};
        int area1 = leetcode_0084.largestRectangleArea(height1);
        System.out.println(area1);


        int[] height2 = new int[] {2, 4};
        int area2 = leetcode_0084.largestRectangleArea(height2);
        System.out.println(area2);


        int[] height3 = new int[] {2, 1, 2};
        int area3 = leetcode_0084.largestRectangleArea(height3);
        System.out.println(area3);
    }

}
