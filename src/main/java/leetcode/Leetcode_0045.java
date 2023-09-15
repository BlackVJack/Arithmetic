package leetcode;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库第0045题 跳跃游戏2
 **/
public class Leetcode_0045 {

    public int jump(int[] nums) {
        // TODO 处理特殊情况, 长度为1, 起点即终点
        int length = nums.length;
        if (length == 1) return 0;

        // TODO 记录步数
        int step = 0;

        // TODO 遍历
        for (int i = 0; i < length; ) {
            // TODO 记录从当前点开始跳, 可达最远的距离
            int farthest = i + nums[i];

            // TODO 可达最远的距离, 如果能跳到超过终点, 则返回步数 + 1
            if (farthest >= length - 1) return step + 1;

            // TODO 标记 某个点的下标, 这个点的下一跳可达最远距离
            int mark = i;

            // TODO 开始遍历
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j + nums[i + j] > farthest) {
                    farthest = i + j + nums[i + j];
                    mark = i + j;
                }
            }
            // TODO 跳到标记点, 此点的下一跳可达最远
            i = mark;

            // TODO 走一步, 步数 + 1
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        Leetcode_0045 leetcode_0045 = new Leetcode_0045();

        int[] nums1 = new int[] {3, 2, 1};
        System.out.println(leetcode_0045.jump(nums1));

        int[] nums2 = new int[] {1, 2};
        System.out.println(leetcode_0045.jump(nums2));


        int[] nums3 = new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(leetcode_0045.jump(nums3));

        int[] nums4 = new int[] {0};
        System.out.println(leetcode_0045.jump(nums4));
    }

}
