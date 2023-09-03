package leetcode;

import tools.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 12:39
 *
 * 力扣题库第47题: 全排列(2)
 * 给定一个可包含重复数字的序列 nums, 按任意顺序 返回所有不重复的全排列。
 *
 * 示例1:
 *      输入：nums = [1,1,2]
 *      输出：
 *          [[1,1,2],
 *          [1,2,1],
 *          [2,1,1]]
 * 示例2:
 *      输入：nums = [1,2,3]
 *      输出：[[1,2,3],
 *              [1,3,2],
 *              [2,1,3],
 *              [2,3,1],
 *              [3,1,2],
 *              [3,2,1]]
 */
public class Leetcode_0047 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        int[] used = new int[length];
        int[] pre = new int[length];
        Sort.quickSort(nums, 0, length - 1);
        for (int i = 0; i < length; i++) {
            pre[0] = nums[i];
            used[i] = 1;
            permute(used, pre, nums, 1);
            used[i] = 0;
        }
        return result;
    }

    public void permute(int[] used, int[] array, int[] nums, int length) {
        if (length == nums.length) {
            List<Integer> tempResult = new ArrayList<>();
            for (int i : array) tempResult.add(i);
            result.add(tempResult);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && used[i - 1] == 1 && nums[i] == nums[i - 1]) continue;
            used[i] = 1;
            array[length] = nums[i];
            permute(used, array, nums, length + 1);
            used[i] = 0;
        }
    }




    public static void main(String[] args) {
        Leetcode_0047 target = new Leetcode_0047();
        int[] nums = new int[] {1, 1, 2};
        List<List<Integer>> lists = target.permuteUnique(nums);
        lists.forEach(System.out::println);
    }

}
