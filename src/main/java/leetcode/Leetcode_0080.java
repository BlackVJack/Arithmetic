package leetcode;

import java.util.Arrays;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/10 21:15
 *
 * 力扣题库第0080题 删除有序数组中的重复项
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  示例1
 *      输入: nums = [1,1,1,2,2,3]
 *      输出: 5(需要对数组做出相应修改)
 *
 *  示例2
 *      输入: nums = [0,0,1,1,1,1,2,3,3]
 *      输出: 7(需要对数组做出相应修改)
 */
public class Leetcode_0080 {

    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int j = i + 1;
            if (nums[i] != nums[j]) continue;
            // TODO 寻找重复的数字
            while (++j < length && nums[i] == nums[j]) {
                // TODO 标记为被删除
                nums[j] = -10001;
            }
            i = j - 1;
        }

        // TODO 找到第一个被标记为删除的地方
        int mark = -1;
        while (++mark < length && nums[mark] != -10001);

        int j = mark + 1;
        while (j < length) {
            while (j < length && nums[j] == -10001) j++;
            if (j >= length) break;
            nums[mark++] = nums[j++];
        }
        return mark;
    }

    public static void main(String[] args) {
        Leetcode_0080 leetcode_0080 = new Leetcode_0080();

        int[] nums1 = new int[]{1,1,1,2,2,3};
        System.out.println("输入=>> " + Arrays.toString(nums1));
        int length1 = leetcode_0080.removeDuplicates(nums1);
        System.out.print("输出=>> ");
        for (int i = 0; i < length1; i++) {
            System.out.printf("%d ", nums1[i]);
        }
        System.out.println();

        int[] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println("输入=>> " + Arrays.toString(nums2));
        int length2 = leetcode_0080.removeDuplicates(nums2);
        System.out.print("输出=>> ");
        for (int i = 0; i < length2; i++) {
            System.out.printf("%d ", nums2[i]);
        }
        System.out.println();
    }

}
