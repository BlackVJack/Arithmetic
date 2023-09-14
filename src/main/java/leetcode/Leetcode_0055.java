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

        int farthest = 0;
        for (int i = 0; i < length - 1; i++) {
            if (!flag[i]) return false;
            int reach = i + nums[i];
            if (reach <= farthest) continue;
            farthest = reach;
            if (farthest >= length) return true;
            for (int j = 1; j <= nums[i]; j++) {
                flag[i + j] = true;
            }
        }
        return flag[length - 1];
    }


    public static void main(String[] args) {

    }

}
