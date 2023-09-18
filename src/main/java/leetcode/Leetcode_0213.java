package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/17 21:20
 *
 * 力扣题库第0213题 打家劫舍2
 *
 *
 */
public class Leetcode_0213 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(getMax(nums, 0, length - 1), getMax(nums, 1, length));
    }

    public int getMax(int[] nums, int start, int length) {
        int[] res = new int[length];
        res[start] = nums[start];
        res[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[length - 1];
    }

    public static void main(String[] args) {

    }

}
