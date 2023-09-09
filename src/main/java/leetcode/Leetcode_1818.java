package leetcode;

import java.util.Arrays;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/9 19:00
 *
 * 力扣题库第1818题 绝对差值和
 *
 *
 */
public class Leetcode_1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int length = nums1.length;

        // int[] array = new int[length];
        // for (int i = 0; i < length; i++) {
        //     array[i] = nums1[i];
        // }
        // Arrays.sort(array);

        long sum = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums1[i] == nums2[i]) continue;
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            // TODO 剪枝: 如果差值比 "可减小的值" 还小就没有必要搜索
            if (diff <= max) continue;

            // TODO 解法1: 循环外排序, 二分查找
            // max = Math.max(max, diff - binarySearch(array, 0, length - 1, nums2[i]));

            // TODO 解法2: 不排序, 直接暴力查找
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                min = Math.min(min, Math.abs(nums2[i] - nums1[j]));
            }
            max = Math.max(max, diff - min);
        }
        return (int) ((sum - max) % 1000000007);
    }

    public int binarySearch(int[] array, int left, int right, int target) {
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                min = Math.min(min, array[mid] - target);
                right = mid - 1;
            }
            else if (array[mid] < target) {
                min = Math.min(min, target - array[mid]);
                left = mid + 1;
            }
            else return 0;
        }
        return min;
    }

    public static void main(String[] args) {
        Leetcode_1818 leetcode_1818 = new Leetcode_1818();

        int[] nums11 = new int[]{1, 7, 5};
        int[] nums21 = new int[]{2, 3, 5};

//        System.out.println(leetcode_1818.minAbsoluteSumDiff(nums11, nums21));


        int[] nums12 = new int[]{1,10,4,4,2,7};
        int[] nums22 = new int[]{9,3,5,1,7,4};

        System.out.println("answer : " + leetcode_1818.minAbsoluteSumDiff(nums12, nums22));
    }
}
