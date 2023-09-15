package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库第0169题 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 **/
public class Leetcode_0169 {

    // TODO 统计遍历
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new  HashMap<>();

        for (int res : nums) {
            map.merge(res, 1, Integer::sum);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > n) return key;
        }
        return 0;
    }

    // TODO 排序取中位数
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {

    }

}
