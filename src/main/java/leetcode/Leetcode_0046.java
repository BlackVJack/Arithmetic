package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 14:43
 *
 * 力扣题库第46题: 全排列(1)
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例1:
 *      输入：nums = [1,2,3]
 *      输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例2:
 *      输入：nums = [0,1]
 *      输出：[[0,1],[1,0]]
 *
 * 示例3:
 *      输入：nums = [1]
 *      输出：[[1]]
 *
 */
public class Leetcode_0046 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        int[] used = new int[length];
        int[] pre = new int[length];
        for (int i = 0; i < length; i++) {
            pre[0] = nums[i];
            used[i] = 1;
            myPermute(used, pre, nums, 1);
            used[i] = 0;
        }
        return result;
    }

    public void myPermute(int[] used, int[] array, int[] nums, int length) {
        if (length == nums.length) {
            List<Integer> tempResult = new ArrayList<>();
            for (int i : array) tempResult.add(i);
            result.add(tempResult);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            array[length] = nums[i];
            myPermute(used, array, nums, length + 1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> permute = new Leetcode_0046().permute(nums);
        permute.forEach(System.out::println);
    }

}
