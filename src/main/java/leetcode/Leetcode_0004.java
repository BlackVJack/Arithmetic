package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/10 1:51
 *
 * 力扣题库第0004题 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n))
 */
public class Leetcode_0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int L = len1 + len2;

        int i = 0;
        int j = 0;
        int k = 0;
        int[] array = new int[L];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) array[k++] = nums1[i++];
            else array[k++] = nums2[j++];
        }
        while (i < len1) {
            array[k++] = nums1[i++];
        }
        while (j < len2) {
            array[k++] = nums2[j++];
        }


        if(L % 2 == 0) return (array[L / 2] + array[L / 2 - 1]) / 2.0;
        return array[L / 2];
    }

}
