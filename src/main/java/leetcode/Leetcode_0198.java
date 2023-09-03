package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 17:52
 *
 * 乐扣题库第0198题 打家劫舍
 *
 *   你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 *   影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *   如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 *   给定一个代表每个房屋存放金额的非负整数数组，计算你
 *   不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 */
public class Leetcode_0198 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[] result = new int[length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[length - 1];
    }

    public static void main(String[] args) {
        Leetcode_0198 leetcode_0198 = new Leetcode_0198();
        int[] nums1 = new int[] {1,2,3,1};

        int[] nums2 = new int[] {2,7,9,3,1};

        int rob1 = leetcode_0198.rob(nums1);
        int rob2 = leetcode_0198.rob(nums2);

        System.out.println(rob1);
        System.out.println(rob2);
    }

}
