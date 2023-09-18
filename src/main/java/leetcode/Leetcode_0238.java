package leetcode;

import java.util.Arrays;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/16 16:19
 *
 * 力扣题库第0238题 除自身以外数组的乘积
 *
 *
 */
public class Leetcode_0238 {


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] nums1 = new int[length];
        int[] nums2 = new int[length];

        nums1[0] = 1;
        for (int i = 1; i < length; i++) {
            nums1[i] = nums1[i - 1] * nums[i - 1];
        }

        nums2[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            nums2[i] = nums2[i + 1] * nums[i + 1];
        }

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = nums1[i] * nums2[i];
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        Leetcode_0238 leetcode_0238 = new Leetcode_0238();

        int[] nums1 = new int[]{1, 2, 3, 4};
        leetcode_0238.productExceptSelf(nums1);
    }
}
