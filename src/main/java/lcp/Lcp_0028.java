package lcp;

import java.util.Arrays;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/8 0:04
 *
 * 力扣题库LCP.0028 采购方案
 */
public class Lcp_0028 {

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        long sum = (long) length * (length - 1) / 2;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                sum -= (right - left);
                right--;
            }
            else left++;
        }
        sum %= 1000000007;
        return (int) sum;
    }

    public static void main(String[] args) {
        Lcp_0028 lcp_0028 = new Lcp_0028();

        int[] nums = new int[]{};
        // 92235
        System.out.println(lcp_0028.purchasePlans(nums, 92235));
    }

}
