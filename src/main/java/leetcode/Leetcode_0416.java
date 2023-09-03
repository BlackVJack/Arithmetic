package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 18:10
 *
 * 力扣题库第0416题: 分割等和子集
 *
 *
 */
public class Leetcode_0416 {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0) return false;
        sum /= 2;

        int length = nums.length;
        int[][] dp = new int[length + 1][sum + 1];
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int num = nums[i - 1];
                if (num > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - num] + num, dp[i - 1][j]);
                }
            }
        }
        return dp[length][sum] == sum;
    }


    public static void main(String[] args) {
        Leetcode_0416 leetcode_0416 = new Leetcode_0416();

        int[] nums1 = new int[] {1,5,11,5};

        int[] nums2 = new int[] {1,2,3,5};

        boolean rob1 = leetcode_0416.canPartition(nums1);
        boolean rob2 = leetcode_0416.canPartition(nums2);

        System.out.println(rob1);
        System.out.println(rob2);
    }
}
