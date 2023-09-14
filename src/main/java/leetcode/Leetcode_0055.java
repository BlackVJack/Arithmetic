package leetcode;

import java.util.Stack;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/14 23:31
 *
 * 力扣第0055题 跳跃游戏
 *
 */
public class Leetcode_0055 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) return true;

        boolean[] flag = new boolean[length];
        flag[0] = true;
        int i = 0;
        while (i < length - 1) {
            if (!flag[i]) return false;
            if (i + nums[i] >= length - 1) return true;
            for (int j = 1; j <= nums[i]; j++) {
                flag[i + j] = true;
            }
            i++;
        }
        return flag[length - 1];
    }

    
    public static void main(String[] args) {

    }

}
