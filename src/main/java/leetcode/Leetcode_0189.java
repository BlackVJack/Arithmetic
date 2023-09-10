package leetcode;

import java.util.Arrays;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/10 20:15
 *
 * 力扣题库第0189题 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *  示例1
 *      输入: nums = [1,2,3,4,5,6,7], k = 3
 *      输出: [5,6,7,1,2,3,4]
 *
 *  示例2
 *      输入: nums = [-1,-100,3,99], k = 2
 *      输出: [3,99,-1,-100]
 *
 *
 */
public class Leetcode_0189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;

        k %= length;
        int kp = length - k;
        int[] res = new int[length];

        // TODO 解法1.1: 手动复制数组
//        for (int i = 0; i < k; i++) {
//            res[i] = nums[kp + i];
//        }
//        for (int i = k; i < length; i++) {
//            res[i] = nums[i - k];
//        }
//
//        for (int i = 0; i < length; i++) {
//            nums[i] = res[i];
//        }

        // TODO 解法1.2: 系统方法复制数组
//        System.arraycopy(nums, kp, res, 0, k);
//        System.arraycopy(nums, 0, res, k, length - k);
//        System.arraycopy(res, 0, nums, 0, length);

        // TODO 解法2: 翻转数组 3次
        reverseArray(nums, 0, length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, length - 1);

    }

    public void reverseArray(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Leetcode_0189 leetcode_0189 = new Leetcode_0189();

        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        int k1 = 3;
        System.out.println("原数组: " + Arrays.toString(nums1));
        System.out.println("翻转k=" + k1 + "次");
        leetcode_0189.rotate(nums1, k1);
        System.out.println("结果: " + Arrays.toString(nums1));


        int[] nums2 = new int[]{-1,-100,3,99};
        int k2 = 2;
        System.out.println("原数组: " + Arrays.toString(nums2));
        System.out.println("翻转k=" + k2 + "次");
        leetcode_0189.rotate(nums2, k2);
        System.out.println("结果: " + Arrays.toString(nums2));


    }
}
