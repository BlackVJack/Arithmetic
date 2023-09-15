package leetcode;

import java.util.Stack;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 15:19
 *
 * 力扣题库第0042题 接雨水
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  示例1
 *      输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *      输出: 6
 *  示例2
 *      输入: height = [4,2,0,3,2,5]
 *      输出: 9
 *
 */
public class Leetcode_0042 {

    public int trap(int[] height) {
        int length = height.length;
        int[] h = new int[length + 2];
        int maxHeight = 0;
        for (int i = 0; i < length; i++) {
            if (maxHeight > height[i]) maxHeight = height[i];
            h[i + 1] = height[i];
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(h[0]);
        int max = 0;
        int result = 0;
        for (int i = 1; i < length + 2; i++) {
            int num = h[i];
            if (num >= max) {
                while (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    result += (max - pop);
                }
                max = num;
            }
            stack.push(num);
        }

        Stack<Integer> stack2 = new Stack<>();
        max = stack.peek();
        stack2.push(stack.pop());
        for (int i = stack.size() - 1; i >= 0; i--) {
            int num = stack.get(i);
            if (num >= max) {
                while (!stack2.isEmpty()) {
                    Integer pop = stack2.pop();
                    result += (max - pop);
                }
                max = num;
            }
            stack2.push(num);
        }
        return result;
    }


    public static void main(String[] args) {
        Leetcode_0042 leetcode_0042 = new Leetcode_0042();
        int[] height1 = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap1 = leetcode_0042.trap(height1);
        System.out.println(trap1);


        int[] height2 = new int[] {4, 2, 3};
        int trap2 = leetcode_0042.trap(height2);
        System.out.println(trap2);
    }

}
