package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/14 22:47
 *
 * 力扣题库第0026题 删除有序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 *
 */
public class Leetcode_0026 {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        int remove = 0;
        int i, j;
        for (i = 0; i < length - 1; i++) {
            j = i + 1;
            while (j < length && nums[j] == nums[i]) {
                nums[j] = -10001;
                remove++;
                j++;
            }
            i = j - 1;
        }

        j = 0;
        while (j < length && nums[j] != -10001) j++;
        i = j + 1;
        while (i < length && nums[i] == -10001) i++;


        while (i < length && j < length) {
            nums[j++] = nums[i];
            nums[i++] = -10001;
            while (j < length && nums[j] != -10001) j++;
            while (i < length && nums[i] == -10001) i++;

        }
        return length - remove;
    }

    public static void main(String[] args) {

    }

}
