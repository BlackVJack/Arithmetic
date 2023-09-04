package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Black Jack
 * @date 2023/7/18.
 **/
public class Leetcode_0018 {

    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
     * （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     *  示例1 :
     *      输入：nums = [1,0,-1,0,-2,2], target = 0
     *      输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *  示例2 :
     *      输入：nums = [2,2,2,2,2], target = 8
     *      输出：[[2,2,2,2]]
     */
    public static void main(String[] args) {



    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        int length = nums.length;
        quickSort(nums, 0, length - 1);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < length - 3; i++) {
            int a = nums[i];

            // TODO 剪枝
            if (i > 0 && a == nums[i - 1]) continue;
            if ((long) a + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) a + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;


            for (int j = i + 1; j < length - 2; j++) {
                int b = nums[j];
                long s = a + b;
                // TODO 剪枝
                if (j > i + 1 && b == nums[j - 1]) continue;
                if ((s + nums[j + 1] + nums[j + 2]) > target) break;
                if (s + nums[length - 1] + nums[length - 2] < target) continue;

                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    int c = nums[l];
                    int d = nums[r];
                    long sum = s + c + d;
                    if (sum == target) {
                        set.add(generate(a, b, c, d));
                        l++;
                    }
                    if (sum < target) l++;
                    else r--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    // TODO 快排 - 核心(规划)代码
    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = getMid(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }

    // TODO 快排 - 局部排序
    public int getMid(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {

            while (left < right) {
                if (array[right] < key) {
                    array[left] = array[right];
                    break;
                }
                right--;
            }

            while (left < right) {
                if (array[left] > key) {
                    array[right] = array[left];
                    break;
                }
                left++;
            }
        }

        array[left] = key;
        return left;
    }

    // TODO 归并
    public List<Integer> generate(int a, int b, int c, int d) {
        int[] array_1 = new int[2];
        int[] array_2 = new int[2];

        if (a < b) {
            array_1[0] = a;
            array_1[1] = b;
        }

        else {
            array_1[0] = b;
            array_1[1] = a;
        }

        if (c < d) {
            array_2[0] = c;
            array_2[1] = d;
        }

        else {
            array_2[0] = d;
            array_2[1] = c;
        }


        List<Integer> result = new ArrayList<>();
        int j = 0;
        int k = 0;
        for (int i = 0; i < 4; i++) {
            if(j < 2 && k < 2) {
                if (array_1[j] < array_2[k]){
                    result.add(array_1[j++]);
                }
                else {
                    result.add(array_2[k++]);
                }
            }
            else if (j < 2) {
                result.add(array_1[j++]);
            }
            else if (k < 2) {
                result.add(array_2[k++]);
            }
        }

        return result;
    }



}
