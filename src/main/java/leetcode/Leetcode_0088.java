package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/14 22:36
 *
 * 力扣题库第0088题 合并两个有序数组
 *
 *
 */
public class Leetcode_0088 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[length--] = nums1[i--];
            }
            else {
                nums1[length--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[length--] = nums2[j--];
        }
    }

    public static void main(String[] args) {

    }

}
