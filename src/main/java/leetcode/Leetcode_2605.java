package leetcode;

/**
 * @author 王臻毅
 * @date 2023/9/5.
 *
 * 力扣题库 第 2605 题 从两个数字数组里生成最小的数字
 *
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，
 * 每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 **/
public class Leetcode_2605 {

    public int minNumber(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];

        int[] map = new int[10];

        for (int i : nums1) {
            if (i < min1) min1 = i;
            map[i]++;
        }
        for (int i : nums2) {
            if (i < min2) min2 = i;
            map[i]++;
        }

        for (int i = 0; i < 10; i++) {
            if (map[i] >= 2) return i;
        }

        return Math.min(min1, min2) * 10 + Math.max(min1, min2);
    }

    public static void main(String[] args) {

    }

}
