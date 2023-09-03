package tools;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 14:37
 *
 * 排序算法
 */


public class Sort {

    /**
     * 快速排序
      * @param nums 数组
     * @param left 左边坐标
     * @param right 右边坐标
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = findMid(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    public static int findMid(int[] nums, int left, int right) {
        int key = nums[left];
        while (left < right) {
            while (left < right) {
                if (nums[right] < key) {
                    nums[left] = nums[right];
                    break;
                }
                right--;
            }
            while (left < right) {
                if (nums[left] > key) {
                    nums[right] = nums[left];
                    break;
                }
                left++;
            }
        }
        nums[left] = key;
        return left;
    }


    /**
     * 选择排序
     * @param nums 数组
     */
    public static void selectSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int mark = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[mark]) mark = j;
            }
            if (mark != i) {
                int temp = nums[i];
                nums[i] = nums[mark];
                nums[mark] = temp;
            }
        }
    }



    public static void showNums(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
    }


    public static void compareQuickSortAndSelectSort() {
        Random random = new Random();

        int[] arrayQuick = new int[2000000];
        int[] arraySelect = new int[2000000];

        for (int i = 0; i < 2000000; i++) {
            int temp = random.nextInt();
            arrayQuick[i] = temp;
            arraySelect[i] = temp;
        }

        long quickStart = System.currentTimeMillis();
        quickSort(arrayQuick, 0, 1999999);
        long quickEnd = System.currentTimeMillis();

        long selectStart = System.currentTimeMillis();
        selectSort(arraySelect);
        long selectEnd = System.currentTimeMillis();


        long timeQuick = quickEnd - quickStart;
        long timeSelect = selectEnd - selectStart;

        System.out.println("快速排序耗时");
        System.out.println(timeQuick);
        System.out.format("%02d : %02d : %02d\n",
                timeQuick / (1000 * 60 * 60) % 60/* 时 */,
                timeQuick / (1000 * 60)% 60/* 分 */,
                timeQuick / 1000 % 60/* 秒 */);// 格式化字符串输出

        System.out.println("选择排序耗时: ");
        System.out.println(timeSelect);
        System.out.format("%02d : %02d : %02d\n",
                timeSelect / (1000 * 60 * 60) % 60/* 时 */,
                timeSelect / (1000 * 60)% 60/* 分 */,
                timeSelect / 1000 % 60/* 秒 */);// 格式化字符串输出


    }
}
