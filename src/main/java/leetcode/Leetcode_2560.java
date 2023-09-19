package leetcode;

import java.util.Arrays;

/**
 * @author 王臻毅
 * @date 2023/9/19.
 *
 * 力扣题库第2560题 打家劫舍4
 **/
public class Leetcode_2560 {

    public int minCapability(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        // TODO 找到最大值和最小值
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        if (k == 1) return min;

        min = 0;
        while (min + 1 < max) {
            int mid = (max + min) / 2;
            if (getCount(nums, mid) >= k) {
                max = mid;
            }
            else {
                min = mid;
            }
        }
        return max;
    }


    public int getCount(int[] nums, int target) {
        int dp1 = 0;
        int dp2 = 0;

        for (int num : nums) {
            if (num > target) {
                dp1 = dp2;
            }
            else {
                int temp = dp2;
                dp2 = Math.max(dp1 + 1, dp2);
                dp1 = temp;
            }
        }
        return dp2;
    }


    public static void main(String[] args) {
        Leetcode_2560 leetcode_2560 = new Leetcode_2560();

//        int[] nums1 = {2, 3, 5, 9};
//        int k1 = 2;
//        System.out.println(leetcode_2560.minCapability(nums1, k1));
//
//
//        int[] nums2 = {5038,3053,2825,3638,4648,3259,4948,4248,4940,2834,109,5224,5097,4708,2162,3438,4152,4134,551,3961,2294,3961,1327,2395,1002,763,4296,3147,5069,2156,572,1261,4272,4158,5186,2543,5055,4735,2325,1206,1019,1257,5048,1563,3507,4269,5328,173,5007,2392,967,2768,86,3401,3667,4406,4487,876,1530,819,1320,883,1101,5317,2305,89,788,1603,3456,5221,1910,3343,4597};
//        int k2 = 28;
//        System.out.println(leetcode_2560.minCapability(nums2, k2));


        int[] nums3 = {1, 2, 2, 1};
        int k3 = 2;
        System.out.println(leetcode_2560.minCapability(nums3, k3));
    }

}
