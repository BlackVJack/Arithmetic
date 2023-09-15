package leetcode;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库第0274题 H指数
 *
 **/
public class Leetcode_0274 {

    public int hIndex(int[] citations) {
        quickSort(citations, 0, citations.length - 1);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > i) h++;
        }
        return h;
    }

    /**
     * 快速排序核心
     * @param nums 数组
     * @param left 左边坐标
     * @param right 右边坐标
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = findMid(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }



    /**
     * 快排的分治函数
     * @param nums 数组
     * @param left 左指针
     * @param right 右指针
     * @return "中间"位置
     */
    public int findMid(int[] nums, int left, int right) {
        int key = nums[left];
        int start = left;
        while (left < right) {
            while (left < right && nums[right] < key) {
                right--;
            }

            while (left < right && nums[left] >= key) {
                left++;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[start] = nums[left];
        nums[left] = key;
        return left;
    }


    public static void main(String[] args) {
        Leetcode_0274 leetcode_0274 = new Leetcode_0274();

        int[] citations1 = new int[] {3,0,6,1,5};
        System.out.println(leetcode_0274.hIndex(citations1));


        int[] citations2 = new int[] {1,3,1};
        System.out.println(leetcode_0274.hIndex(citations2));
    }

}
