package leetcode;

import java.util.Arrays;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/3 16:14
 *
 * 力扣题库第1921题 消灭怪物的最大数量
 *
 * 你正在玩一款电子游戏，在游戏中你需要保护城市免受怪物侵袭。
 * 给你一个 下标从 0 开始 且长度为 n 的整数数组 dist ，其中 dist[i] 是第 i 个怪物与城市的 初始距离（单位：米）。
 *
 * 怪物以 恒定 的速度走向城市。
 * 给你一个长度为 n 的整数数组 speed 表示每个怪物的速度，其中 speed[i] 是第 i 个怪物的速度（单位：米/分）。
 *
 * 怪物从 第 0 分钟 时开始移动。你有一把武器，并可以 选择 在每一分钟的开始时使用，包括第 0 分钟。
 * 但是你无法在一分钟的中间使用武器。这种武器威力惊人，一次可以消灭任一还活着的怪物。
 *
 * 一旦任一怪物到达城市，你就输掉了这场游戏。如果某个怪物 恰 在某一分钟开始时到达城市，这会被视为 输掉 游戏，在你可以使用武器之前，游戏就会结束。
 *
 * 返回在你输掉游戏前可以消灭的怪物的 最大 数量。如果你可以在所有怪物到达城市前将它们全部消灭，返回  n 。
 *
 *
 * 示例1
 *      输入: dist = [1,3,4], speed = [1,1,1]
 *      输出: 3
 *
 * 示例2
 *      输入: dist = [1,1,2,3], speed = [1,1,1,1]
 *      输出: 1
 *
 * 示例3
 *      输入: dist = [3,2,4], speed = [5,3,2]
 *      输出: 1
 */


public class Leetcode_1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int length = dist.length;
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = 1.0 * dist[i] / speed[i];
        }
        // quickSort(array, 0, length - 1);
         Arrays.sort(array);
         int time = 0;
         for (int i = 0; i < length; i++) {
             if (array[i] - time > 0) time++;
             else break;
         }
         return time;
    }


    public int eliminateMaximum2(int[] dist, int[] speed) {
        int length = dist.length;
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = 1.0 * dist[i] / speed[i];
        }


        return 1;
    }


    public static void main(String[] args) {
        Leetcode_1921 leetcode_1921 = new Leetcode_1921();
        int[] dist1 = new int[]{1, 3, 4};
        int[] speed1 = new int[]{1, 1, 1};

        int eliminate1 = leetcode_1921.eliminateMaximum(dist1, speed1);
        System.out.println(eliminate1);
    }

}
