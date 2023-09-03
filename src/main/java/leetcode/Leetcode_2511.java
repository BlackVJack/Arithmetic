package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/3 20:21
 *
 * 力扣题库第2511题 最多可以摧毁的敌人城堡数目
 * 题目太长:
 *  题目链接:https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/?envType=daily-question&envId=2023-09-02
 */


public class Leetcode_2511 {

    public int captureForts(int[] forts) {
        int max = 0;
        int count = 0;
        int length = forts.length;
        for (int i = 0; i < length; i++) {
            int fort = forts[i];
            if (fort == 0) continue;
            i++;
            while (i < length) {
                int enemy = forts[i];
                if (enemy == 0) {
                    count++;
                    if (i == length - 1) count = 0;
                }
                else {
                    if (enemy == fort) count = 0;
                    i--;
                    break;
                }
                i++;
            }
            if (count > max) max = count;
        }
        return max;
    }

}
